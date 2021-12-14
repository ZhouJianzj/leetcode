package Map;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashTable {
    public static void main(String[] args) {
        Hashtable<String, Stu> ht = new Hashtable<>();
        ht.put("one",new Stu());
        ht.put("two",new Stu());
        ht.put("three",new Stu());
        ht.put("three",new Stu());

        Enumeration<String> keys = ht.keys();
        while (keys.hasMoreElements()){
            //返回的的是key
            System.out.println(keys.nextElement());
        }
        Enumeration<Stu> elements = ht.elements();
        while (elements.hasMoreElements()){
            //获取的value
            System.out.println(elements.nextElement());
        }
    }
}
class Stu{
    String name;
    String address;
}