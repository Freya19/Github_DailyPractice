package gepeng18.test;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Singleton {
    private Singleton instance;

    private Singleton(){

    }
    private Singleton getInstance(){
        if (instance == null){
            synchronized(Singleton.class) {
                if (instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {


    }
}
