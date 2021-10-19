public class Father {
    public static  void test(){
        System.out.println("++++++");
    }
}

/**
 *子类不可以从写父类的静态方法，但是可以调用，底层实现是对象级别的调用
 */
class Son extends Father{
    public static void main(String[] args) {
        Son son = new Son();
        son.test();
    }

}
