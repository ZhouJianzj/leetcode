package thread;

public class Thread1 extends Thread {

    public Thread1 (){
//        这里执行实在main线程中执行的
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run (){
//        这里执行的实在子线程下执行的
        System.out.println(Thread.currentThread().getName());
    }
}
class Test1 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
    }
}
