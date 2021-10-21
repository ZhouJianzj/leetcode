package thread;

public class Thread10 extends Thread{
    private B b;
    public Thread10(){}
    public Thread10 (B b){
        this.b = b;
    }
    @Override
    public void run() {
//        线程调用setValues方法
        b.setValues(2,"zhoujian");
    }
}
class B{
    private int id = 1;
    private String name = "niniinni";

    public void setValues(int id, String name){
        this.id = id;
//        在设置name的时候会线程休眠一会
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
        System.out.println(Thread.currentThread().getName() +  getValues());
    }
    public String getValues (){
        return "=="+ this.id + "===>" + this.name;
    }
}
class Test10{
    /**
     * 演示的出现脏读的现象
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        B b = new B();
        Thread10 thread10 = new Thread10(b);
        thread10.start();
//        出现脏读
        System.out.println(Thread.currentThread().getName() +  b.getValues());
//        等待一下没有脏读了，所以锁在读或则是写的时候都需要添加锁
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() +  b.getValues());

    }
}
