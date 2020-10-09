package gepeng18.代码运行提;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SUper {
    static {
        System.out.println("supper");
    }
}

public class A5 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);


        System.out.println("主线程");
        es.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("12345");
            }
        });

        List<Runnable> remains = es.shutdownNow();

    }
}
