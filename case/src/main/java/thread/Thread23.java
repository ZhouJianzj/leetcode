package thread;

import java.util.concurrent.locks.ReentrantLock;

public class Thread23 {
    public static void main(String[] args) {
//        锁对象必须是同一个
        ReentrantLock reentrantLock = new ReentrantLock();
        LockThread lockThread = new LockThread(reentrantLock);
        LockThread lockThread1 = new LockThread(reentrantLock);
        lockThread.start();
        lockThread1.start();
    }
}
class LockThread extends Thread{
    /**
     * 可重入锁
     */
     ReentrantLock reentrantLock;
     public LockThread(ReentrantLock reentrantLock){
         this.reentrantLock = reentrantLock;
     }

    public  void doLock(){
//        获取锁
        try{
            reentrantLock.lock();
            int i;
            for ( i = 0; i < 1111111; i++) {

            }
            System.out.println(Thread.currentThread().getName() + "____" + i);
        } finally {
            //        释放锁
            reentrantLock.unlock();
        }
    }

    @Override
    public void run() {
        doLock();
    }
}
