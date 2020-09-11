package gepeng18.test.多线程;

import java.util.concurrent.*;

public class 线程池 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<Object> res = pool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                System.out.println("开始运行了");
                return "123";
            }
        });
        Thread.sleep(1000);
        System.out.println("主函数");
        Object o = res.get();
        System.out.println(o);
        pool.shutdown();
    }
}
