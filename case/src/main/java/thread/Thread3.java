package thread;

public class Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println("+++++" + Thread.currentThread().getName());
        System.out.println(this.isAlive());
    }
}
class Test3{
    public static void main(String[] args) {
        Thread thread = new Thread3();
//       线程还没有启动所以是死
        System.out.println(thread.isAlive());
        thread.start();
        System.out.println(thread.isAlive());
//      演示线程执行完毕之后的状态，显然也是死的
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.isAlive());
    }
}
