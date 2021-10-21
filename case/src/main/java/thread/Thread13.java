package thread;

public class Thread13 extends Thread {
    private  boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("方法开始+++++");
        while (flag){

        }
        System.out.println("方法结束-----");
    }
}
class AA{
    public static void main(String[] args) {
//        Thread13 thread13 = new Thread13();
//        thread13.start();
//
//        thread13.setFlag(true);
        AAA aaa = new AAA();
        new AAAA(aaa).start();
        aaa.setFlag(false);
    }
}
class AAA{
    private Boolean flag = true;

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    public void run() {
        System.out.println("方法开始+++++");
        while (flag){

        }
        System.out.println("方法结束-----");
    }
}
class AAAA extends  Thread{
    private AAA aaa;
    public AAAA(AAA aaa){
        this.aaa = aaa;
    }
    @Override
    public void run() {
        aaa.run();
    }
}

