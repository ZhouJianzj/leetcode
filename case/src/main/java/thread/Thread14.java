package thread;

/**
 * 实现asc算法
 */
public class Thread14 {
    public static void main(String[] args) {
        final TTT ttt = new TTT();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 999999990; i++) {
                    System.out.println(ttt.increment());
                }
            }
        }).start();
    }
}

class TTT{
    volatile long counter = 1;

    /**
     *
     * @param counterf 一个线程第一次获取的共享数据
     * @param counterb 一个线程在更新内存之前,获取的共享数据
     * @return
     */
    public boolean asc(long counterf,long counterb){
        if (counterf == counterb){
            return true;
        }else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public long increment(){
//        先保存在主内存中获取的值,也就是本地内存的值
        long value = counter;
//        实现加一
        long incrementValue = counter + 1;
//        比较 本地内存的值和 主内存中的值比较,一样就实现加一,不一样就还是那个值
        while(asc(value,counter)){
            counter = incrementValue;
        }
        return value;
    }
}
