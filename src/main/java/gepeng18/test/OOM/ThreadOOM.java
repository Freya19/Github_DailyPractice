package gepeng18.test.OOM;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;

/**
 * 禁止运行这个代码：：：：笔记本跑到11万就挂了
 i = 111476
 i = 111477
 i = 111478
 i = 111479
 i = 111480
 i = 111481
 i = 111482
 Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 at java.lang.Thread.start0(Native Method)
 at java.lang.Thread.start(Thread.java:717)
 at gepeng18.test.OOM.ThreadOOM.main(ThreadOOM.java:28)
 */
public class ThreadOOM {
    public static void main(String[] args) {
        for(int i=0;;i++){
            System.out.println("i = " + i);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(10000000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
