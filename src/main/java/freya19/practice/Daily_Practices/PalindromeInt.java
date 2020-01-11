package freya19.practice.Daily_Practices;

//这是个 有bug的解法 —— 视频提供的

public class PalindromeInt {

    public static void main(String[] args) {
        int  a = 432234;
        PalindromeInt p = new PalindromeInt();
        System.out.println(p.isPalindrome(a));
    }

    public boolean isPalindrome(int x) {  //假设传入的数字是 ： 4 3 2 3 4
        if(x<0) {
            return false;
        }else{
            int div =1;
            int num =x;
            while(num/div>=10){
                div*=10;
            }                               // 初次得到的div= 1 0000
            while(num!=0){
                int l = num/div; //最高位   // 初次得到的l = 4
                int r = num%10; //个位      // 初次得到的r = 4
                if(l == r) {
                    num = (x-l*div)/10;  //去除首尾后剩下的数字   323
                    div/=100; //一轮后，数字减少两位    5位数 编变成 3位数
                }else{
                    return false;
                }
            } return true;
        }
    }
}
