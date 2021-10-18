public class ResolveOom {
    public static void main(String[] args) {
//       虚拟机试图使用的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
//       堆内存， 年轻代加上老年代的内存空间，原空间理论上存在物理上没有
        long metaMemory = Runtime.getRuntime().totalMemory();
        System.out.println(maxMemory /(double)1024/1024);
        System.out.println(metaMemory /(double)1024/1024);


    }
}
