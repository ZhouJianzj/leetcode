package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread26 {
    public static void main(String[] args) {
        Interruptibly interruptibly = new Interruptibly(new ReentrantLock());
        interruptibly.start();
//       使用  lock.lock();没有生效，生效的话会抛出异常
        interruptibly.interrupt();
    }


}

class Interruptibly extends Thread{

    private ReentrantLock lock;

    public Interruptibly(ReentrantLock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
//            lock.lock();
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();


    }
}
