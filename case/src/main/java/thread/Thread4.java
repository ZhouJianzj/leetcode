package thread;

public class Thread4  {
    public static void main(String[] args) throws InterruptedException {
//      演示一个简单的计时器
        Thread thread = new Thread();
        int time = 8;
        System.out.println("up");
        while (true) {
            if (time == 0){
                break;
            }
            System.out.println(time--);
            Thread.sleep(1000);
        }
        System.out.println("down");

    }
}
