package thread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Thread15 {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                       Counter.getCounter().requestTotal();
                    int a = new Random().nextInt(5 - 1 + 1);
                    if (a % 2 == 0){
                        Counter.getCounter().requestSuccess();
                    }else {
                        Counter.getCounter().requestFailed();
                    }
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(Counter.getCounter().getTotal());
        System.out.println(Counter.getCounter().getSuccess());
        System.out.println(Counter.getCounter().getFailure());



    }
}
class Counter{

    private Counter(){}

    private final static Counter counter = new Counter();

    public static Counter getCounter(){

        return counter;
    }
    private  final AtomicLong total = new AtomicLong(0);
    private  final AtomicLong success = new AtomicLong(0);
    private  final AtomicLong failure = new AtomicLong(0);

    public  void requestTotal(){
        total.incrementAndGet();
    }public  void requestSuccess(){
        success.incrementAndGet();
    }public  void requestFailed(){
        failure.incrementAndGet();
    }

    public long getTotal() {
        return total.get();
    }

    public long getSuccess() {
        return success.get();
    }

    public long getFailure() {
        return failure.get();
    }
}
class AAAAA{
//    单例模式使用私有构造器
    private AAAAA(){}

    private static final  AAAAA aaaaa = new AAAAA();

    public static  AAAAA getAAAAA(){
        return AAAAA.aaaaa;
    }

}
