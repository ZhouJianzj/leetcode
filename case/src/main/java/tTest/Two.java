package tTest;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Two {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\file.txt"));
        fileOutputStream.write("AAbcdea22dferwplkCC321ou1".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.flush();
        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\file.txt"));
        TreeSet<Character> characterSet = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 -o2;
            }
        });
        int a ;
        while ((a = fileInputStream.read()) != -1){
            characterSet.add((char) a);
        }
        fileInputStream.close();
    }
}
