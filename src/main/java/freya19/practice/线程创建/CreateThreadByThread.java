package freya19.practice.线程创建;

/**
 * 继承 Thread类，重写run方法
 * 缺点：单继承性。如果该类已经继承了别的类，就不能继承Thread了
 * */
public class CreateThreadByThread extends Thread {

    /** run方法中是线程体 */
    @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // 因为继承了Thread类，所以可以直接创建该 线程对象
        CreateThreadByThread thread1 = new CreateThreadByThread();
        // 线程进入就绪态，等待CPU调用
        thread1.start();

        CreateThreadByThread thread2 = new CreateThreadByThread();
        thread2.start();
    }
}
