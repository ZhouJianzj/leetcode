import com.sun.org.apache.xpath.internal.Arg;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.MarshalledObject;
import java.util.*;

public class TestEmp {
    public static void main(String[] args) {
        //1
        //模拟100个员工
//        ArrayList<Emp> emps = new ArrayList<>(100);
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            emps.add(new Emp("name" + i,(random.nextInt(12) + 18)));
//        }
//        System.out.println(handleEmp(emps));

        //2
//        String str = "qweqweqwe123123";
//        System.out.println(TestEmp.toUpLow(str));

//        3
//        System.out.println(findString2("s"));

        //4
//        System.out.println(countString("ssrrggg"));

        System.out.println(count("aaaassssddd"));

//        System.out.println(findString2("src"));
    }

    /**
     * 相同年龄的员工存放到map中，age为key，emp为value
     * @param emps
     * @return
     */
    public static Map<Integer, List<Emp>> handleEmp(List<Emp> emps){
        //创建一个数据容器
        HashMap<Integer, List<Emp>> map = new HashMap<>(256);
        for (Emp emp:emps){
            //key是否已经存在
           if (map.containsKey(emp.getAge())){
               //存在就获取list往list里面添加一个emp
               map.get(emp.getAge()).add(emp);
           }else{
               //key不存在就往map中添加一个key和list的value，在往list中添加emp
               ArrayList<Emp> empList = new ArrayList<>();
               empList.add(emp);
               map.put(emp.getAge(),empList);
           }
        }
        return map;
    }

    /**
     * 字符串转大写每隔4个字符追加一个*
     * StringBuffer
     * @param s
     * @return
     */
    public static String toUpLow(String s){
        String s1 = s.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = 0; i < s1.length(); i++) {
            if (i % 4 == 0 && i > 0){
                stringBuilder.append("*");
            }
            stringBuilder.append(s1.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**
     * 方法一 查找src在指定字符串中出现的次数
     * indexOf
     * @return
     */
//    public static int findString(String str){
//        String str1 = "srcsrc qw src eadsafdsdadsd src  asdas src";
//        int count = 0;
//        int i = 0;
//        while (true){
//            str1 = str1.substring(i);
//            if ((i = str1.indexOf(str)) != -1){
//
//                i = i + str.length();
//                count++;
//            }else {
//                break;
//            }
//        }
//        return count;
//
//    }

    /**
     * 方法二
     * 首先indexOf（s,i）获取第一次出现的src的s下标
     * 然后indexOf(s,i+1)获取第二次出现的src的s下标
     * @param s
     * @return
     */
    public static int findString2(String s){
        String str1 = "srcsrc qw src eadsafdsdadsd src  asdas src";
        int count = 0;
        int i = -1;
        while ((i = str1.indexOf(s,++i)) != -1){
            count++;
        }
        return count;
    }


    /**
     * 计算一个自定义字符串中字符在指定字符串里面出现的次数，
     * 并且给出现次数作value ，字符串作为key
     *
     * 首先自身去重
     * 然后去字符串中遍历寻找
     * @return
     */
    public static Map<String, Integer> countString(String string){
        String str = "asdasdasdagsfdfdsgfdghdfdgsdfwererwregessrrggg";
        char[] chars = str.toCharArray();

        HashMap<String, Integer> map = new HashMap<>(256);
        String[] strings = new String[string.length()];

        for (int i = 0; i < string.length(); i++) {
            strings[i] = String.valueOf(string.charAt(i));
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(strings));
        for (String s:set){
            map.put(s,0);
        }

        for (String s:set){
            for (int i = 0; i < chars.length; i++) {
                if (s.equals(String.valueOf(chars[i])) ){
                    Integer integer = map.get(s);
                    integer++;
                    map.put(s,integer);
                }
            }
        }
        return map;
    }

    /**
     * 指定字符串中字符个数
     * @param string
     * @return
     */
    public static Map<Character, Integer> count(String string){
        HashMap<Character, Integer> map = new HashMap<>(128);
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                Integer integer = map.get(chars[i]);
                integer++;
                map.put(chars[i],integer);
            }else {
                map.put(chars[i],1);
            }
        }
        return map;
    }
}






@Data
@AllArgsConstructor
@NoArgsConstructor
class Emp{
    String name;
    Integer age;
}