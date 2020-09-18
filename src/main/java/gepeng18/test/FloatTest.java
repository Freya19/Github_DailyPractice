package gepeng18.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
@AllArgsConstructor
class Person{
    int age;
}
public class FloatTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Object> task = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                System.out.println("线程开始执行了");
                return 5;
            }
        });
        task.run();
        System.out.println("主线程开始执行了");

        Object o = task.get();
        System.out.println(o);

    }
}
