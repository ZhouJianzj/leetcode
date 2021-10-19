package thread;

public class Thread2 extends Thread {
    public Thread2 (){
        System.out.println("=====" + Thread.currentThread().getName());
        System.out.println("=====" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("+++++" + Thread.currentThread().getName());
        System.out.println("+++++" + this.getName());
    }
}
class Test2{
    public static void main(String[] args) throws InterruptedException {
//      创建对象的时候是会调用无参构造实在main线程中的
        Thread thread2 = new Thread2();
        thread2.setName("1");
        thread2.start();
        Thread.sleep(1000);
        System.out.println("================");
//        这里的run中的this表示的是线程 1   也就是thread2对象
        Thread thread = new Thread(thread2);
        thread.setName("2");
        thread.start();
    }
}
