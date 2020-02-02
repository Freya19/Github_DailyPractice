package freya19.practice.Daily_Practices;

public class RlockAndNonReentrantLock{

// 不可重入锁：如果当前的线程调用某个方法已经获得锁了，再调用其他的方法想要获得锁的时候，会阻塞
    static class lock{
        public boolean locked = false;
        // 加锁
        public synchronized void isLock() throws InterruptedException {
            while (locked){ wait(); }
            locked = true;
        }
        //解锁
        public synchronized void unlock(){
            locked = false;
            notify();
        }
    }

    lock lock = new lock();

    public void a() throws InterruptedException {
        lock.isLock();
        doSth();
        lock.unlock();
    }
    //不可重入
    public void doSth() throws InterruptedException {
        lock.isLock();
        lock.unlock();
    }

// 可重入锁：某线程已经获得某个锁，可以再次获取这个锁而不会出现死锁现象
    public void test() {
        //  第一次获得锁
        synchronized(this){
            while(true) {
                //  第二次获得同样的锁
                synchronized(this) {
                    System.out.println("ReentrantLock!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RlockAndNonReentrantLock rlock = new RlockAndNonReentrantLock();
        rlock.test();
        rlock.a(); //第一次调用时，locked=false，此时while循环不走，线程未阻塞；但locked=true；
        rlock.doSth();//调用这个方法，内部调用lock.islock时就会阻塞
    }

}