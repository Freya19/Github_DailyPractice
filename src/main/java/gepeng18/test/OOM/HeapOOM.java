package gepeng18.test.OOM;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    private static void createObject(){
        final int oneM = 1024 * 1024;
        byte[] bytes = new byte[oneM];
    }

    private static void notOOM() {
        for(int i=0;i<100000;i++){
            createObject();
        }
    }



    private static void addObject(List list){

        final int oneM = 1024 * 1024;
        byte[] a5 = new byte[oneM];
        list.add(a5);
    }

    private static void OOM() {
        List<Object> list = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            addObject(list);
        }
    }

    public static void main(String[] args) {
        OOM();
    }
}

/**
 $ java -XX:+PrintCommandLineFlags
 -XX:InitialHeapSize=199414144 -XX:MaxHeapSize=3190626304 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndivi
 dualAllocation -XX:+UseParallelGC

 初始化堆：1/64
 最大堆： 1/4
 */

/**
 * java -XX:+PrintCommandLineFlags  打印
 * javac xx.java
 * java -XX:PrintGCDetails gepeng18/test/OOM/HeapOOM  运行
 */

/**
 * java +参数  运行之前设置
 * jps + jinfo 运行过程中查看
 */
