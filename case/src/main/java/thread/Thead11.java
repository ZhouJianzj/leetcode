package thread;

public class Thead11 {
    public static void main(String[] args) {
        C c = new C();
        Thread t1 = new T(c);
        Thread t = new T(c);
//        Thread t2 = new T2(c);
//        演示的是当一个线程执行这个同步方法的时候出现了异常，会自动的释放当前的锁，一遍让阻塞的线程拿到当前的锁
        t.start();
        t1.start();
//        t2.start();

    }
}
class  T extends Thread{
    private C c;
    public T(C c){
        this.c=c;
    }

    @Override
    public void run() {
        c.doOne();
    }
}
class  T2 extends Thread{
    private C c;
    public T2(C c){
        this.c=c;
    }

    @Override
    public void run() {
        c.doTwo();
    }
}
class  C{
    public synchronized static  void doOne(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+ "-----" + i);
            if (i ==3){
                System.out.println(i/0);
            }
        }
    }
    public void doTwo(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+ "-----" + i);
        }
    }
}
