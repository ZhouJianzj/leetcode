package clone;

/**
 * @author zhoujian
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        TestT testT = new TestT();
        testT.nameTwo = "nametwo";
        System.out.println(testT.nameTwo);
        TestT clone = (TestT) testT.clone();
        System.out.println(clone.nameTwo);
    }
}
class TestT implements Cloneable{

    private String  nameOne;
    public String nameTwo;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
