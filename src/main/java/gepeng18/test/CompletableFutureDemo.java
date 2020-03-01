package gepeng18.test;


import java.util.*;
import java.util.concurrent.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 2, 1, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );


        final FutureTask futureTask = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 123;
            }
        });
        final Thread thread1 = new Thread(futureTask);
        threadPoolExecutor.execute(thread1);
    }
}
