package gepeng18.专题.动态规划;

public class L5最长回文子串_中心扩展 {

    private String res = "";
    public String longestPalindrome(String s) {
        if(s.length()==0)
            return res;

        StringBuilder newSbud = new StringBuilder();

        for(int i=0;i<s.length();i++)
            newSbud.append("#").append(s.charAt(i));  //如 babad  ==> #b#a#b#a#d#
        String newS = newSbud.append("#").toString();

        for(int i=0;i<newS.length();i++) {
            expandAroundCenter(newS, i);
        }

        StringBuilder resSbud = new StringBuilder();
        for(int i=0;i<res.length();i++)
            if(res.charAt(i)!='#')
                resSbud.append(res.charAt(i));
        return resSbud.toString();
    }

    private void expandAroundCenter(String s, int current) {
        int l = current;
        int r = current;
        while (l-1 >= 0 && r+1 < s.length() && s.charAt(l-1) == s.charAt(r+1)) {
            l--;
            r++;
        }
        res = res.length()>s.substring(l,r+1).length()?res:s.substring(l,r+1);
    }

    public static void main(String[] args) {
        String s = "abb";
        L5最长回文子串_中心扩展 l5 = new L5最长回文子串_中心扩展();
        String s1 = l5.longestPalindrome(s);
        System.out.println(s1);
    }
}
