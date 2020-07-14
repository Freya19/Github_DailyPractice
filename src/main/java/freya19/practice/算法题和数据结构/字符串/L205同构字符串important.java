package freya19.practice.算法题和数据结构.字符串;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的
 *
 * 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
 */

public class L205同构字符串important {
    public boolean isIsomorphic(String s, String t) {
        int [] preIndexOfS = new int[256];
        int [] preIndexOfT = new int[256];
        for (int i=0;i<s.length();i++){
            char cs=s.charAt(i),ct=t.charAt(i);
            if(preIndexOfS[cs]!=preIndexOfT[ct]){
                return false;
            }
            preIndexOfS[cs]=i+1;
            preIndexOfT[ct]=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="paper",t="title";
        boolean isomorphic = new L205同构字符串important().isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
