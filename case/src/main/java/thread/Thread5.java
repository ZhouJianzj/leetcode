package thread;

public class Thread5  extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
//            表示的是让位的意思，
            Thread.yield();

        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
class Test5{
    public static void main(String[] args) {
        Thread5 thread5 = new Thread5();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {

        }
        thread5.start();
        System.out.println(System.currentTimeMillis() - start);
    }
}
