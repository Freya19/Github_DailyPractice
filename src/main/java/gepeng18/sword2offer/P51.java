package gepeng18.sword2offer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class P51 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(8);
        list.set(5,6);
    }


    public static String replaceSpace(StringBuffer str) {
       // we are family  we%20.....
        int p1=str.length()-1;
        int start = 0;
        int num=0;
        while(start<str.length()){
            if(str.charAt(start)==' '){
                num++;
            }
            start++;
        }
        int p2=p1+num*2;


        for(int i=0;i<2*num;i++)
            str.append(' ');

        while(p1>=0){
            if(str.charAt(p1)==' ')
            {
                str.setCharAt(p2,'0');
                str.setCharAt(p2-1,'2');
                str.setCharAt(p2-2,'%');
                p2 = p2-3;
                p1--;
            }else{
                str.setCharAt(p2,str.charAt(p1));
                p2--;
                p1--;
            }
        }
        return str.toString();


    }
}
