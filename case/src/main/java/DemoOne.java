import java.util.HashMap;

/**
 *题目： 给定一个数组 array{2,7,11,15}
 *      给定一个target = 7
 *      求返回数组中两元素的和等于target的元素下标
 * @author zhoujian
 */
public class DemoOne {
    public static void main(String[] args) {
        DemoOne demoOne = new DemoOne();
//        System.out.println(demoOne.methodOne());
//        System.out.println(demoOne.methodTwo());
//        System.out.println(demoOne.methodThree());
        System.out.println(demoOne.methodFour());
    }
    int[] array = {11,15,2,7};
    int target = 9;
    /**
     * 解法1：使用两个for循环
     * @return 下标
     */
    public String methodOne(){
        for(int a = 0 ; a < array.length; a++){
            for (int b = 0;b < array.length;b++){
                if (b == a){
                    break;
                }
                if ( target == array[a] + array[b]){
                    return "下标为：" + a + " " + "下标为：" + b;
                }
            }
        }
        return "没有相加为target的元素";
    }

    /**
     * 方法2：
     * @return
     */
    public String methodTwo(){
        for (int a = 0;a < array.length;a++ ){
           for(int b = (a + 1);b < array.length; b++){
               if ( array[a] + array[b] == target){
                   return  a + ":" + b;
               }
           }
        }
        return "没有这两个元素";
    }

    /**
     * 方法3
     * @return
     */
    public String methodThree(){
        for (int a = 0 ;a < array.length; a++){
            for (int b = a +1 ; b < array.length;b++){
                if (target - array[a] == array[b]){
                    return a + ":" + b;
                }
            }
        }
        return "没有这两个元素";
    }

    /**
     * 使用hashmap
     * @return
     */
    public String methodFour(){
        HashMap<Integer, Integer> map = new HashMap();
//        装元素
        for (int a = 0;a < array.length;a++){
            map.put(array[a],a);
        }
//        遍历数组
        for (int b = 0; b < array.length;b++){
            int i = target - array[b];
//         求另一个数是不是包含在里面，并且不能是下标为b的元素
            if (map.containsKey(i) && map.get(i) != b ){
                return map.get(i) + ":" + b;
            }
        }
        return "没有这两个元素";
    }
}
