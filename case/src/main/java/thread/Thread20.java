package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 多个生产者多消费者
 */
public class Thread20 {
    public static void main(String[] args) {
//        数据仓库
        Data data = new Data();
//        生产者
        TTwo tTwo1 = new TTwo(data);
        tTwo1.setName("生产者+++1");
        TTwo tTwo2 = new TTwo(data);
        tTwo2.setName("生产者+++2");
        TTwo tTwo3 = new TTwo(data);
        tTwo3.setName("生产者+++3");
//        消费者
        TOne tOne1 = new TOne(data);
        tOne1.setName("消费者-1");
        TOne tOne2 = new TOne(data);
        tOne2.setName("消费者2");
        TOne tOne3 = new TOne(data);
        tOne3.setName("消费者3");

        tOne1.start();
        tOne2.start();
        tOne3.start();
        tTwo1.start();
        tTwo2.start();
        tTwo3.start();


    }
}

/**
 * 消费
 */
class TOne extends Thread{
    Data data ;
    public TOne(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        while(true){
            data.pop();
        }
    }
}

/**
 * 生产
 */
class TTwo extends Thread{
    Data data ;
    public TTwo(Data data){
        this.data = data;
    }

    @Override
    public void run() {
       while (true){
           data.push();
       }
    }
}
class Data{
    List list = new ArrayList<String>();

    /**
     * 消费
     */
    public synchronized void pop(){
        while (list.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        System.out.println(Thread.currentThread().getName()+ "-----消费" );
        notifyAll();
    }

    /**
     * 生产
     */
    public synchronized  void push(){
//        没有使用while的时候会出现没有控制之针异常，是因为没有在唤醒之后再一次的验证
        while (list.size() == 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String str =  new Random().nextInt() + "";
        list.add(str);
        System.out.println(Thread.currentThread().getName()+ "-----生产" );
//        当有多个消费者的时候会出现假死现象，在没有使用notifyAll的时候
        notifyAll();
    }
}


