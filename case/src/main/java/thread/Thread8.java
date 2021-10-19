package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread8 {
    public static void main(String[] args) {
        final Two two = new Two();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                     while (true) {
                         System.out.println(Thread.currentThread().getName() + "->" +two.getNum());
                         try {
                             Thread.sleep(100);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                }
            }).start();
        }
    }

}

/**
 * 不能保证原子性
 */
 class One{
    static int numl;
    public static int getNum(){
        return numl++;
    }
}

/**
 * 使用java中提供的Atomic修的原子类实现线程的原子性
 */
class Two{
     AtomicInteger numl = new AtomicInteger();
    public  int getNum(){
        return numl.getAndIncrement();
    }
}

