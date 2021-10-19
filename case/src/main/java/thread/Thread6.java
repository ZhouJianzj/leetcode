package thread;

public class Thread6  extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=======" + i);
            if (this.isInterrupted()){
                return;
            }
        }
    }
}
class Test6{
    public static void main(String[] args) {
        Thread6 thread6 = new Thread6();
        thread6.start();
//        这里的打断并不是真正的停止子线程，而是给子线程打一个布尔标志，具体的打断还需要到子线程中实现
        thread6.interrupt();
    }
}
