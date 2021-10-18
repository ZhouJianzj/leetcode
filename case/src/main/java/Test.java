import java.lang.*;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {


      int[] nums = {1,2,3,4,5,7,8,10};
      int length = nums.length;
      int end = nums[nums.length - 1];
      int que = length - end;
      for (int i = 0; i < nums.length; i++) {
        if (nums[++i] -nums[i] == 1 ){
            System.out.println(nums[i]);
        }
      }


    }
}


