package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示使用tryLocked（时长）
 */
public class Thread24 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        TestTryThread testTryThread1 = new TestTryThread(reentrantLock);
        TestTryThread testTryThread2 = new TestTryThread(reentrantLock);
        testTryThread1.setName("one");
        testTryThread2.setName("Two");
        testTryThread1.start();
        testTryThread2.start();

    }

}

/**
 * 演示tryLock加时间
 */
class TestTryThread extends Thread{
    private ReentrantLock reentrantLock;

    public TestTryThread (ReentrantLock reentrantLock){
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        try {
//            获取🔒假如锁没有被占用直接返回true获取到锁，
//            假如被别的线程占用了并且在指定的等待时长没有拿到锁就直接不执行
            if (reentrantLock.tryLock(1, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName() + "---" + "执行.....");
                Thread.sleep(2000);
            }else {
//                当二个线程等待超时的时候会执行这下面这个代码
                System.out.println(Thread.currentThread().getName() + "---" + "等待超时不执行了");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
//            如果当前线程还占有着锁，就释放当前锁
            if (reentrantLock.isHeldByCurrentThread()){
                reentrantLock.unlock();
            }
        }
    }
}