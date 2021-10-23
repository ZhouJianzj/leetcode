package thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 使用管道实现线程之前的通信
 */
public class Thread21 {
    static PipedInputStream input = new PipedInputStream();
    static PipedOutputStream output = new PipedOutputStream();
    public static void main(String[] args) throws IOException {
//        管道输入连接管道输出
        input.connect(output);

        new Thread(new Runnable() {
            public void run() {
                try {
//                    一个线程输入
                    PipInput();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
//                    一个线程输出
                    PipOutput();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 管道输入
     */
    public static void  PipInput() throws IOException {
//        以一个byte字节数组装在
        byte[] bytes = new byte[8];
        int read = input.read(bytes);
//        当装在的数组中没有的了时候会返回为  -1
        while (read != -1){

            System.out.println(new String(bytes,0,read));

            read =input.read(bytes);
        }
        output.close();
    }

    /**
     * 管道输出
     */
    public static void  PipOutput() throws IOException {

        for (int i = 0; i < 100; i++) {
            String str =  i + "";
            output.write(str.getBytes());
        }
        output.close();

    }


}

