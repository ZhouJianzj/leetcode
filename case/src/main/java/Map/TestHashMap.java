package Map;

import java.security.Key;
import java.time.temporal.ValueRange;
import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("One","one");
        stringStringHashMap.put("Two","two");
        stringStringHashMap.put("Three","three");
        stringStringHashMap.put("Four","four");

//        stringStringHashMap.entrySet().stream().forEach((value)->{
//            System.out.println(value.getKey() + ":" + value.getKey());
//        });
//

        stringStringHashMap.forEach((K,V)->{
            System.out.println( K + ":" + V);
        });
    }
}
