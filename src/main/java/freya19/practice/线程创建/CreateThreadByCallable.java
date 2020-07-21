package freya19.practice.线程创建;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 */
public class CreateThreadByCallable implements Callable {

    /** call方法中是线程体 */
    @Override
    public String call() throws Exception {
        for(int i=0;i<6;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
        return "Thread created success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread() 只接收Runnable类型的参数，而FutureTask实现了Runnable接口
        // FutureTask：实现了Runnable接口，构造函数又需要传入 Callable接口
        // 这里通过了FutureTask接触了Callable接口
        FutureTask futureTask = new FutureTask<>(new CreateThreadByCallable());

        //一个futureTask只会计算一次(第二个参数是线程名字），所以第二个BBB是不会执行的
        new Thread(futureTask,"AAA：").start();
        new Thread(futureTask,"BBB：").start();

        //应该这么写
        FutureTask futureTask1 = new FutureTask<>(new CreateThreadByCallable());
        FutureTask futureTask2 = new FutureTask<>(new CreateThreadByCallable());

        new Thread(futureTask1,"Thread1：").start();
        new Thread(futureTask2,"Thread2：").start();

        // *  要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞
        // *  futureTask.get() 需要放在最后执行，这样不会导致主线程阻塞。可以通过自旋来获取
            System.out.println("result: "+futureTask.get());

    }

}
