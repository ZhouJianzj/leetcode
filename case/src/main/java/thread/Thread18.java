package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 模拟的是cas算法的ABA问题
 * 当一个线程修改了共享数据的时候修改了两次最终导致共享数据还是之前的那个值
 * 当第二个线程来修改共享数据的时候会出现以为没有线程来修改的现象\
 *
 * 也就是实现cas的算法比较的值会随着修改会出现一致的问题
 *
 * AtomicReference  使用这个就会出现ABA这个问题
 */
public class Thread18 {
     static AtomicReference<String> str = new AtomicReference<String>("abc");

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                str.compareAndSet("abc","def");
                System.out.println(Thread.currentThread().getName()+ "===>" + str.get());
                str.compareAndSet("def","abc");
                System.out.println(Thread.currentThread().getName()+ "===>" + str.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            public void run() {

                str.compareAndSet("abc","zj");
                System.out.println(Thread.currentThread().getName()+ "===>" + str.get());
            }
        });
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println(str.get());
    }
}

/**
 * 使用专门戳 实现，实现每一次的验证数据都不可能一致，来解决ABA问题
 */
class ABA{
    static AtomicStampedReference<String> reference =
            new AtomicStampedReference<String>("abc",0);
    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(new Runnable() {
            public void run() {
                reference.compareAndSet("abc","def",
                            reference.getStamp(),reference.getStamp()+1);

                System.out.println(Thread.currentThread().getName()+ "++>" + reference.getStamp() + "===>" + reference.getReference());

                reference.compareAndSet("def","abc",
                        reference.getStamp(),reference.getStamp()+1);

                System.out.println(Thread.currentThread().getName()+ "++>" + reference.getStamp() + "===>" + reference.getReference());

            }
        });
        Thread two = new Thread(new Runnable() {
            public void run() {

                reference.compareAndSet("abc","zhoujian",
                        reference.getStamp(),reference.getStamp()+1);

                System.out.println(Thread.currentThread().getName()+ "++>" + reference.getStamp() + "===>" + reference.getReference());

            }
        });
         one.start();
         two.start();
         one.join();
         two.join();
        System.out.println(Thread.currentThread().getName()+ "++>" + reference.getStamp() + "===>" + reference.getReference());
    }
}
