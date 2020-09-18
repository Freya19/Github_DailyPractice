package gepeng18.考试.微盟;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.ArrayList;

<<<<<<< HEAD:src/main/java/gepeng18/考试/微盟/引号中的字符串1.java
public class 引号中的字符串1 {

=======
public class 打印 {
>>>>>>> 22f162aa555c977cd8b9c57f9b35847747fe75ac:src/main/java/考试/打印.java
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
        return res;
    }


    public static void main(String[] args) throws Exception {
        ArrayList<String> res = func("123\"ccc\"12345123\"ccc\"12345123\"ccc\"12345123\"ccc\"12345");
        System.out.println(res);
    }


}
