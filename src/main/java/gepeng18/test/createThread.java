package gepeng18.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class Thread1 extends Thread{

    @Override
    public void run() {
        System.out.println("线程1");
    }
}

class Thread3 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("线程3");
        return null;
    }
}

public class createThread {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new FutureTask<>(new Thread3())).start();
    }
}
