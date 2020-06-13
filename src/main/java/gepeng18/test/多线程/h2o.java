package gepeng18.test.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class h2o {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(1);

    public h2o() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseHydrogen.run();
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        o.release();
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println((s+"b").hashCode()==s.hashCode());

        Boolean bb = Boolean.FALSE;
    }

}
