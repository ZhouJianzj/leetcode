package thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Thread22 {
//线程本地的的意思，SimpleDateFormat可以在线程内部获取
    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();

    static class MyThread implements Runnable{
        int i = 0;
        public void run() {
//            获取
            SimpleDateFormat simpleDateFormat = threadLocal.get();
            if (simpleDateFormat == null){
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
            try {
                System.out.println(simpleDateFormat.parse("2022-11-11 10:11:" + ++i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new MyThread()).start();
        }
    }
}
