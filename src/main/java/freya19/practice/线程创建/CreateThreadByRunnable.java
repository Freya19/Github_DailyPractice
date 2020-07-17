package freya19.practice.线程创建;

/** 实现Runnable接口，重写run方法*/
public class CreateThreadByRunnable implements Runnable {

    /** run方法中是线程体 */
    @Override
    public void run() {
        for(int i=0;i<=5;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //因为不是继承Thread类的，所以把实现了Runnable接口的对象作为参数传入
        Thread thread1 = new Thread(new CreateThreadByRunnable());
        thread1.start();

        Thread thread2 = new Thread(new CreateThreadByRunnable());
        thread2.start();

    }
}
