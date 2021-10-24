package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示解决死锁的问题
 */
public class Thread25 {
    public static void main(String[] args) {
        ReentrantLock reentrantLockOne = new ReentrantLock();
        ReentrantLock reentrantLockTwo = new ReentrantLock();
        new TryLOck(reentrantLockOne,reentrantLockTwo,2).start();
        new TryLOck(reentrantLockOne,reentrantLockTwo,1).start();
    }
}
class TryLOck extends Thread{
    private int num;

    private ReentrantLock reentrantLockOne;

    private ReentrantLock reentrantLockTwo;

    public TryLOck(ReentrantLock reentrantLockOne ,ReentrantLock reentrantLockTwo,int num){
        this.reentrantLockOne = reentrantLockOne;
        this.reentrantLockTwo = reentrantLockTwo;
        this.num = num;
    }

    @Override
    public void run() {
        //偶数就先获得一锁，再获得二锁
        if (num % 2 == 0){
            //不停的检索
            while (true){
                try {
                    //这个false while循环还是会执行的
                    if (reentrantLockOne.tryLock()){
                        System.out.println(Thread.currentThread().getName() + "---获取到锁1----还想获取锁2");
                        try {
                            if (reentrantLockTwo.tryLock()){
                                System.out.println(Thread.currentThread().getName() + "---获取到锁2--线程执行完毕");
                                return;
                            }
                        } finally {
                            //执行完释放锁
                            if (reentrantLockTwo.isHeldByCurrentThread()){
                                reentrantLockTwo.unlock();
                            }
                        }
                    }
                } finally {
                    //执行完释放锁
                    if (reentrantLockOne.isHeldByCurrentThread()){
                        reentrantLockOne.unlock();
                    }
                }
            }
        }else {
            while (true){
                try {
                    if (reentrantLockTwo.tryLock()){
                        System.out.println(Thread.currentThread().getName() + "---获取到锁2----还想获取锁1");
                        try {
                            if (reentrantLockOne.tryLock()){
                                System.out.println(Thread.currentThread().getName() + "---获取到锁1--线程执行完毕");
                                return;
                            }
                        } finally {
                            //执行完释放锁
                            if (reentrantLockOne.isHeldByCurrentThread()){
                                reentrantLockOne.unlock();
                            }
                        }
                    }
                } finally {
                    //执行完释放锁
                    if (reentrantLockTwo.isHeldByCurrentThread()){
                        reentrantLockTwo.unlock();
                    }
                }
            }
        }
    }
}
