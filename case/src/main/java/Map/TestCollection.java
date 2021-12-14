package Map;

import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(33);
        objects.add(6);
        objects.add(3);
//        objects.forEach(o -> System.out.println(o));
        Collections.sort(objects);

        Collections.reverse(objects);
        objects.forEach(o -> System.out.println(o));

        Vector<String> strings = new Vector<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        Enumeration<String> elements = strings.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }
}
