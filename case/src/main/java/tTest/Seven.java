package tTest;

import javax.annotation.Resource;
import java.io.*;

public class Seven {
    public static void main(String[] args) throws IOException {
        System.out.println(countNum(readFile(), "hello"));
    }

    public static StringBuilder readFile()throws IOException{
        FileReader fileReader = new FileReader(new File("D:\\b.txt"));
        char[] chars = new char[10];
        StringBuilder stringBuilder = new StringBuilder(1024);
        int a;

        while ( (a = fileReader.read(chars)) != -1){
            String s = new String(chars, 0, a);
            stringBuilder.append(s);
        }
        return stringBuilder;
    }
    public static int countNum(StringBuilder stringBuilder,String s){
        int count = 0;
        int b = -1;
        while ((b = stringBuilder.indexOf(s,++b)) != -1){
            ++count;
        }
        return count;
    }
}
