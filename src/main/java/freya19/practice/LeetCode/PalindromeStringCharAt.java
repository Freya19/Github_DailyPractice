package freya19.practice.LeetCode;
//判断是否是回文数字
public class PalindromeStringCharAt {
    public static void main(String[] args) {
        int a = 12321;
        Solution9 s =new Solution9();
        System.out.println(s.isPalindrome(a));
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }return true;
    }
}