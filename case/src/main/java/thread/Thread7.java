package thread;

public class Thread7 extends Thread {
    @Override
    public void run() {
       while (true) {
           System.out.println("守护线程.......");

       }
    }
}
class Test7{
    public static void main(String[] args) {
        Thread7 thread7 = new Thread7();
//        不会出现子线程的死循环问题
        thread7.setDaemon(true);
        thread7.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

    }
}
