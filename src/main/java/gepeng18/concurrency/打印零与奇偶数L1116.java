package gepeng18.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class 打印零与奇偶数L1116 {
    private int n;

    public 打印零与奇偶数L1116(int n) {
        this.n = n;
    }

    private Semaphore z = new Semaphore(1);
    private Semaphore e = new Semaphore(0);
    private Semaphore o = new Semaphore(0);

    public void zero(IntConsumer printNumber) throws InterruptedException {

        for(int i=0;i<n;i++){
            z.acquire();
            printNumber.accept(0);
            if((i&1)==0)
                o.release();
            else
                e.release();

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            e.acquire();
            printNumber.accept(i);
            z.acquire();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            o.acquire();
            printNumber.accept(i);
            z.acquire();
        }
    }
}
