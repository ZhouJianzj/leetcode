package Map;

import java.io.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;

public class TestProperty {

    public static void main(String[] args) {
        reader();
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
}
