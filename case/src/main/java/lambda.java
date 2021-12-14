/**
 * @author zhoujian
 */
public class lambda {

    public static void main(String[] args) {
//        int i = doTest(new Oper() {
//            public int doOper(int a, int b) {
//                return a + b;
//            }
//        });
//        System.out.println(i);

//        int i = doTest((a, b) -> {
//            return a + b;
//        });
//        System.out.println(i);

        new Thread(()->{
            System.out.println("=================");
        }).start();
    }

    public static int doTest(Oper oper){
        int a = 10;
        int b = 20;
        return oper.doOper(a,b);
    }
}
interface Oper{
   int doOper(int a,int b);
}