package Map;

import java.io.*;
import java.util.*;

public class TestProperty {

    public static void main(String[] args) {
//        reader();
        removeDuplicates();
    }

    public static void writer( ) {
        Properties properties = new Properties();
        properties.setProperty("name","zhoujian");
        try {

            Writer fileWriter = new FileWriter("D:/var/1.txt");
            properties.store(fileWriter,"first commit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试properties读
     */
    public static void reader( ) {
        try {
            FileReader fileReader = new FileReader("D:/var/1.txt");
            Properties properties = new Properties();
            properties.load(fileReader);
            //只获取value
            Enumeration<Object> elements = properties.elements();
            while (elements.hasMoreElements()){
                System.out.println(elements.nextElement());
            }

            //获取key和value
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()){
                Object o = keys.nextElement();
                System.out.println( o + "=" +  properties.getProperty((String) o));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试linkHastSet
     */
    public static void removeDuplicates() {
        String s = "hello";
        char[] chars = s.toCharArray();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            set.add(String.valueOf(chars[i]));
        }

        for (String s1 : set) {
            System.out.println(s1);
        }
    }
}
