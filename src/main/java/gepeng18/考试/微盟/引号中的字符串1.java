package gepeng18.考试.微盟;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

<<<<<<< HEAD
public class 引号中的字符串1 {

=======

public class 引号中的字符串1 {
>>>>>>> 640f1804e978a6988688f7d0c81b2920fdd16c4f
    static ArrayList<String> func(String s) {
        ArrayList<String> res = new ArrayList<>();
        int end = -1;
        while (true) {
            int start = s.indexOf("\"",end+1);
            if ((start == -1)) break;
            end = s.indexOf("\"", start+1);
            if(end!=-1)
                res.add(s.substring(start+1, end));
        }
        new ReentrantLock().newCondition().signal();
        return res;
    }


    public static void main(String[] args) throws Exception {
        ArrayList<String> res = func("123\"ccc\"12345123\"ccc\"12345123\"ccc\"12345123\"ccc\"12345");
        System.out.println(res);
    }


}
