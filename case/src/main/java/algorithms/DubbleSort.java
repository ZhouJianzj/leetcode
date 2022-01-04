package algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhoujian
 */
public class DubbleSort {
    static int[] ints = {1,23,33,43,65,34,12,90};

    public static void main(String[] args) {
         //冒泡排序，执行 length -1 次
         //每比较一次减少一个数字，循环次数减少一次
         //两两比较，互相交换位置。
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1 - i ; j++){
                if (ints[j] > ints[j+1]){
                 int temp = ints[j];
                 ints[j] = ints[j+1];
                 ints[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ints));
    }
}
