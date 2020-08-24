package gepeng18.笔试.京东2021;

import java.util.Scanner;

public class 回文素数 {
    int res = 0;

    // 判断整数 n 是否是素数
    boolean judgePrime(int n) {
        if(n<=1)
            return false;
        // 为什么要 = 因为 9/3==0 所以不能放过3
        for (int i = 2; i*i <= n; i++)
            if (n % i == 0)
                // 有其他整除因子
                return false;
        return true;
    }

    boolean judgePrimeAndpalindrome(Integer num){
        String s = String.valueOf(num);
        int l = 0,r = s.length()-1;
        while (l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else
                return false;
        }
        return true;
    }


    public void listNum(int m,int n){
        for (int i=m;i<=n;i++){
            String s = String.valueOf(i);
            for (int j=0;j<s.length();j++){
                Integer num = Integer.valueOf(s.substring(0,j)+s.substring(j+1));
                if(judgePrime(num)&&judgePrimeAndpalindrome(num)){
                    System.out.println(num);
                    res++;
                }
            }
        }
    }

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        new 回文素数().listNum(m,n);
    }
}
