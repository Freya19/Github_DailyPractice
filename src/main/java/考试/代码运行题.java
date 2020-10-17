package 考试;

import sun.plugin2.applet.context.InitialJNLPExecutionContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class ZS{
    static {
        System.out.println("zs");
    }
}
public class 代码运行题 {
    public static void main(String[] args) {
        LinkedList listt = new LinkedList<>();
        listt.add("a");
        listt.add(2,"b");
        String str = (String)listt.get(1);
        System.out.println(str);


    }
}
