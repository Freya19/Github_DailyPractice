package freya19.practice.线程创建;


import java.util.concurrent.*;

public class CreatThreadByThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

//        threadPool.execute(new CreateThreadByRunnable());

        FutureTask futureTask = new FutureTask<>(new CreateThreadByCallable());

        threadPool.submit(futureTask);

        Future submit = threadPool.submit(new CreateThreadByCallable());



        submit.get();
        threadPool.shutdown();
    }
}
