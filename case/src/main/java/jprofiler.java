import java.util.ArrayList;

public class jprofiler {

    byte[] b = new byte[1 * 1024 * 1024 * 1024];
    static int count = 0;
    public static void main(String[] args) {
       try {
           while(true){
               ArrayList arrayList = new ArrayList();
               arrayList.add(new jprofiler());
               count ++;
           }
       }catch (Error e) {
           System.out.println(count);
       }
    }
}
