/**
 * 静态栈的实现，数组实现栈
 */
public class Stack {
    private  int maxSize;

    private int[] stack;

    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public Boolean isEmpty() {
        return top == -1;
    }
    public Boolean isFull() {
        return top == maxSize -1;
    }

    public void push(int item) {
        if (isFull()){
            throw new RuntimeException("栈满");
        }
        stack[++top] = item;
    }

    /**
     * 出栈
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[top--] ;
    }

}
class HuiWen{
    public static void main(String[] args) {
        Stack stack = new Stack(10);


        String hello = "ada";
        System.out.println(HuiWen.isHuiWen(hello, stack));
    }
    /**
     * 有一个需求就是判断一个字符串是否为回文数据  ada 就是       hello 不是
     */

    public static Boolean isHuiWen(String string,Stack stack){
        int length = string.length();
        String newStr = "";
//        使用压栈

           for (int i = 0;i < length;i++){
               stack.push(string.charAt(i));

       }
//       使用弹栈

           for (int i = 0;i < length;i++){
               char pop = (char)stack.pop();
               newStr += pop;

       }

       if (string.equals(newStr)){
           return true;
       }
        return false;

    }
}
