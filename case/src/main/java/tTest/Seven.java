package tTest;

import java.io.*;

public class Seven {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(new File("D:\\b.txt"));
        char[] chars = new char[10];
        StringBuilder stringBuilder = new StringBuilder(1024);
        int a;
        int count = 0;
        while ( (a = fileReader.read(chars)) != -1){
            String s = new String(chars, 0, a);
            stringBuilder.append(s);
            System.out.println(s);
        }
        int b = -1;
        while ((b = stringBuilder.indexOf("hello",++b)) != -1){
            ++count;
        }
        System.out.println(count);
    }

}
