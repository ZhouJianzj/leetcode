import javax.xml.transform.Source;
import java.util.Random;

public class TeTe {
    public static void main(String[] args) {
        Random random = new Random();
//        int s = random.nextInt(max)%(max-min+1) + min;
        while (true) {
            //[1-2]
            System.out.println((random.nextInt(2)%(2) + 1));
        }


//        while (true) {
//            System.out.println((int) (Math.random() * 2));
//        }
    }
}
