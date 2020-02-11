package gepeng18.concurrency;

import java.security.spec.ECField;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 *
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 *     线程 A 将会调用 one() 方法
 *     线程 B 将会调用 two() 方法
 *     线程 C 将会调用 three() 方法
 *
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 *
 */
public class 按序打印L1114 {
    private int number;
    private Lock lock;
    private Condition condition1;
    private Condition condition2;
    private Condition condition3;
    public 按序打印L1114() {
        number = 1;
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while(number!=1)
                condition1.await();
            printFirst.run();
            number = 2;
            condition2.notifyAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while(number!=2)
                condition2.await();
            printSecond.run();
            number = 3;
            condition3.notifyAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while(number!=3)
                condition3.await();
            printThird.run();
            number = 1;
            condition1.notifyAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }
}
