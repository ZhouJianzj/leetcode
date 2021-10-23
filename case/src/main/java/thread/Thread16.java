package thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Thread16 {
    public static void main(String[] args) throws InterruptedException {
        final AtomicIntegerArray array = new AtomicIntegerArray(10);
        for (int a = 0; a < 10; a++){
           Thread thread =  new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        for (int j = 0; j < 10; j++) {
                            array.incrementAndGet(j);
                        }
                    }
                }
            });
           thread.start();
           thread.join();
        }
        System.out.println(array);

    }
}

