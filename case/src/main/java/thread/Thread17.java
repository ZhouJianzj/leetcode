package thread;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Thread17 {
    public static void main(String[] args) throws InterruptedException {
        User user = new User(10);
        for (int i = 0; i < 100; i++) {
           new Thread_17(user).start();
        }
        Thread.sleep(1000);
        System.out.println(user);
    }
}
class Thread_17 extends Thread{
    private User user;

    public Thread_17(User user){
        this.user = user;
    }
    /**
     * AtomicIntegerFieldUpdater ：原子integer类型的对象属性更新，对应的就是User对象的age
     * 创建一个原子更新器，指定需要更新的对象和对象属性的参数名字
     *
     */
    private AtomicIntegerFieldUpdater<User>  updater =
            AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    @Override
    public void run() {
        updater.incrementAndGet(user);
    }
}
class User{

     int id;
    /**
     * 需要更新的对象的属性必须要使用volatile修饰，不能式静态的也不能使用final修饰
     */
     volatile int age;

    public User( int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
