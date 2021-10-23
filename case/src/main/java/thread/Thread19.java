package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Thread19 {
    static  List list = new ArrayList();

    /**
     * 当array的length大于五的是就恢复初始值
     * 否则就添加数据
     * @param args
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
               synchronized (list){
                   while (true){
                       System.out.println(Thread.currentThread().getName() + "==>" +list.remove("zhoujian"));
                       if (list.size() == 0){
                           try {
                               list.notify();
                               list.wait();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                   }
               }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {

                    synchronized (list){
                        while(true){
                            System.out.println(Thread.currentThread().getName() + "==>" +list.add("zhoujian"));
                            if (list.size() == 5){
                                try {
                                    list.notify();
                                    list.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

/**
 * interrupt使用的是异常机制实现的线程的中断
 */
class Interrupt{
    static final Integer a = 1;
    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Runnable() {
            public void run() {
                synchronized (a){
                    try {
                        System.out.println("========线程在准备等待===========");
                        a.wait();
                        System.out.println("========等待之后的代码===========");
                    } catch (InterruptedException e) {
                        System.out.println("=========线程使用interrupe()结束了异常============");
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();

    }
}

