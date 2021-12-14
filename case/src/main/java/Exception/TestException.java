package Exception;

public class TestException {
    public static void main(String[] args) {
        try {
            new TestException().test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常发生了！");
    }
    void test() throws Exception{
        int a =  10/0;
    }
}
