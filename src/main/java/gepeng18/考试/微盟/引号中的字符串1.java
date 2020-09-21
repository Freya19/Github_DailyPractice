package gepeng18.考试.微盟;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class 引号中的字符串1 {

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
