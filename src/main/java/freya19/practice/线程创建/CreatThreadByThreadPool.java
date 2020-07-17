package freya19.practice.线程创建;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreatThreadByThreadPool {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

//        threadPool.execute(new CreateThreadByRunnable());
        threadPool.submit(new CreateThreadByCallable());

        threadPool.shutdown();
    }
}
