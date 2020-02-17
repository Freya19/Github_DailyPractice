package gepeng18.sword2offer;

import javax.print.DocFlavor;
import java.sql.BatchUpdateException;

public class 替换空格P51 {
    public static void main(String[] args) {
        final String we_are_happy = replaceSpace(new StringBuffer("we are happy"));
        System.out.println(we_are_happy);
    }
    public static String replaceSpace(StringBuffer str) {
        if(str.toString().equals(""))
            return "";

        int start = 0;
        int blankNUm = 0;
        while(start<str.length()){
            if(str.charAt(start)==' '){
                blankNUm++;
            }
            start++;
        }
        int p2 = str.length()+blankNUm*2-1;
        int p1 = str.length()-1;

        final StringBuilder result = new StringBuilder(p2);
        result.append(str);
        for(int i=0;i<p2-p1;i++)
            result.append('1');

        while(p1>=0){
            if(result.charAt(p1)==' '){
                result.setCharAt(p2,'0');
                result.setCharAt(p2-1,'2');
                result.setCharAt(p2-2,'%');
                p2 = p2-3;
                p1 = p1-1;
            }else{
                result.setCharAt(p2,result.charAt(p1));
                p2--;
                p1--;
            }

        }
        return result.toString();
    }


}
