package tTest;

import java.util.regex.Matcher;

public class Three {
    public static void main(String[] args) {
        System.out.println(waterFlower(153));
    }

    /**
     * "水仙花数"是指一个三位数
     * @param num
     * @return
     */
    public static boolean waterFlower(int num){
        String s = String.valueOf(num);
        if (num == Math.pow(Double.parseDouble(s.substring(0, 1)),3)
                + Math.pow(Double.parseDouble(s.substring(1, 2)),3)
                + Math.pow(Double.parseDouble(s.substring(2, 3)),3))
        {
            return true;
        }else {
            return false;
        }
    }
}
