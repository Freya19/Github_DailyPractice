package gepeng18.专题.回溯;


import java.util.ArrayList;
import java.util.List;


public class 全排列 {
    List<String> res = new ArrayList();
    void back(String whole,String current,String remain){
        if (current.length() == whole.length())
           res.add(current);
        for (int i=0;i<remain.length();i++)
            back(whole,current+remain.charAt(i),remain.substring(0,i)+remain.substring(i+1));
    }

    public static void main(String[] args) {
        String a = "ABC";
        全排列 main = new 全排列();
        main.back(a,"",a);
        System.out.println(main.res);
    }
}

