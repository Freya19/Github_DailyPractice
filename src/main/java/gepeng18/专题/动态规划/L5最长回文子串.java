package gepeng18.专题.动态规划;

public class L5最长回文子串 {
    int dp[][] ;
    String maxString="";
    public String longestPalindrome(String s) {

        dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            for(int j=0;j<s.length();j++)
                dp[i][j] = -1;

        for(int i=0;i<s.length();i++)
            for(int j=i;j<s.length();j++)
                solution(s,i,j);
        return maxString;
    }


    private int solution(String s,int l,int r){
        if(dp[l][r]!=-1)
            return dp[l][r];

        if(l==r){
            maxString = s.substring(l,r+1).length()>maxString.length()?s.substring(l,r+1):maxString;
            dp[l][r] = 1;
            return dp[l][r];
        }
        if(r-l==1){
            if((s.charAt(l)==s.charAt(r)))
            {
                maxString = s.substring(l,r+1).length()>maxString.length()?s.substring(l,r+1):maxString;
                dp[l][r] = 1;
            }
            else
                dp[l][r] = 0;
            return dp[l][r];
        }

        if((s.charAt(l)==s.charAt(r))&&(solution(s,l+1,r-1)==1))
        {
            maxString = s.substring(l,r+1).length()>maxString.length()?s.substring(l,r+1):maxString;
            dp[l][r] = 1;
        }
        else
            dp[l][r] = 0;
        return dp[l][r];
    }

    public static void main(String[] args) {
        System.out.println(new L5最长回文子串().longestPalindrome("cbbd"));
    }
}
