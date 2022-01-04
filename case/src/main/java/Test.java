import java.util.Arrays;

public class Test {
    static int a = 10;
    static int[] b = new int[10];
    public static void main(String[] args) {
        int main = 10;
        int count =1;
        doTest(a);
        System.out.println(a);
        System.out.println(Arrays.toString(b ));
    }
    public static void doTest(int a ){
        b[0] = a;
        a = a + 10;
    }
}
