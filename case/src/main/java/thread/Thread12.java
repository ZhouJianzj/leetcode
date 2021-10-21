package thread;

public class Thread12 {
    public static void main(String[] args) throws InterruptedException {
        final D d = new D();
        //演示一
//        调用方法执行里面的while循环
//        d.doWhile();
//        设置falg值，希望能够停止while循环,但是不会达到预期的效果
//        d.setFalg(false);

        //演示二
//        上面的形式不可以那我们就尝试一下使用子线程执行while方法，main线程改变falg值来实现结束while循环
//        这时候会发现是可以终止while循环，但是每次的while循环计数不一致的，这是因为不同的线程是将共享数据复制一份副本到本地内存
//        然后更新完成之后在跟新到主存,之间的数据更新会有延迟实则线程还是安全的
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    d.doWhile();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        Thread.sleep(1000);
//        d.setFalg(false);

//        演示三
//        使用volitile,发现只是加快了更新数据
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    d.doWhile();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        Thread.sleep(50);
//        d.setFalg(false);

        final E e = new E();
        new Thread(new Runnable() {
            public void run() {
                e.setNum(10);


            }
        }).start();
        while(true){
            System.out.println( Thread.currentThread().getName() + "+++++" +e.getNum());
        }
    }
}
class D{
//    private  boolean falg = true;
    //使用这个修饰符,会使得每一个线程修改了共享数据都会即使的更新到主内存,
    // 别的线程中的本地内存中的数据就会失效,会重新从主内存中获取数据
    private volatile boolean falg =true;
    private  int counter = 1;
    public void setFalg(Boolean falg){
        this.falg =  falg;
    }

    public void doWhile() throws InterruptedException {
        while (falg){
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + counter++ );
        }
    }
}
class E{
    private volatile int num = 1;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

/**
 * 修改不会
 */
class RunThread extends Thread {

    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入到run方法中了");
        while (isRunning == true) {
        }
        System.out.println("线程执行完成了");
    }
}

 class Run {
    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();

            Thread.sleep(1000);
            thread.setRunning(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
