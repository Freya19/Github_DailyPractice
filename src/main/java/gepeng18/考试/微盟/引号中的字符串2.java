package gepeng18.考试.微盟;

import java.util.ArrayList;

public class 引号中的字符串2 {

    static ArrayList<String> func(String s) {
       boolean beforeFind = false;
       int index = 0;
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\"'){
                if (!beforeFind){
                    beforeFind = true;
                    index = i;
                }else{
                    res.add(s.substring(index+1,i));
                    beforeFind = false;  // 清除之前的标志位
                }
            }
        }
        return res;
    }


    public static void main(String[] args) throws Exception {
        // 把中间的ccc都打印出来
        ArrayList<String> res = func("123\"ccc\"12345123\"ccc\"12345123\"ccc\"12345123\"ccc\"12345");
        System.out.println(res);
    }


}
