package gepeng18.专题.动态规划;

class L5最长回文子串_错误_滑动窗口 {
    private String res = "";
    // 是否为回文的判断函数
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int l=0,r=-1;
        while(l<s.length()){

            if(r+1<s.length()&&isPalindrome(s.substring(l,r+2))){
                r++;
            }else
                l++;
            if(isPalindrome(s.substring(l,r+1)))
                res = res.length()>s.substring(l,r+1).length()?res:s.substring(l,r+1);
        }
        return res;
    }

    public static void main(String[] args) {
        L5最长回文子串_错误_滑动窗口 l5 = new L5最长回文子串_错误_滑动窗口();
        String s1 = l5.longestPalindrome("babad");
        System.out.println(s1);
    }
}