package tTest;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Four {
    public static void main(String[] args)  {
        System.out.println(questionResolve());
    }
    public static String questionResolve() {
        File file = new File("D:\\a.txt");
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        String result = null;
        try {
            if (file.exists()) {
                fileOutputStream = new FileOutputStream(file, true);
                fileOutputStream.write("Hello world".getBytes(StandardCharsets.UTF_8));
                result =  "文件存在，末尾追加";
                byte[] bytes = new byte[1024];
                fileInputStream = new FileInputStream(file);
                int read = fileInputStream.read(bytes);
                System.out.println(new String(bytes,0,read));

            }else {
                fileOutputStream = new FileOutputStream(file);
                result =  "文件不存在，新建追加";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
