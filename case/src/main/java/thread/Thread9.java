package thread;

public class Thread9 {
    public static void main(String[] args) {
        final Thread9 thread9 = new Thread9();

        new Thread(new Runnable() {
            public void run() {
//                演示的是使用对象锁
//                thread9.forMethod();
//                thread9.synchronMethod();

//                演示的使用类锁
//                new A().doDo();

                thread9.doNot();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
//                thread9.forMethod();
//                thread9.synchronMethod();
//                new A().doDo();
                thread9.doNot();

            }
        }).start();
    }

    /**
     * 加上锁之后线程2会等待线程1的执行完毕才会执行，也就是串行的执行
     * 哪怕是线程1的cpu时间片时间到了还没有执行完，线程2也一直会等待线程1执行
     * 完成才之心这个对象的方法
     * 下面是两种写法效果是一样的
     */
    public void forMethod(){
        synchronized (this){
            for (int i = 0; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName()+ "-->" + i);
            }
        }
    }

    public synchronized void synchronMethod(){
        for (int i = 0; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName()+ "-->" + i);
        }
    }

    /**
     * 演示的是没有使用锁
     */
    public void doNot(){
        for (int i = 0; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName()+ "-->" + i);
        }
    }
}
class  A{
    /**
     * 这个加的是类锁,一百个对象都是一个类锁
     */
    public synchronized static  void doDo(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ "-->" + i);
        }
    }
}
