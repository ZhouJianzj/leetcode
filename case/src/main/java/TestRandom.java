
import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[]{1,2,3,2};
        int[] ints = new int[1];
        int[] ints1 = {1,2,3,4,5,6};

//        int s = random.nextInt(max)%(max-min+1) + min;
        while (true) {
            //[1-2]
            System.out.println((random.nextInt(2)%(2) + 1));
        }
    }
}
