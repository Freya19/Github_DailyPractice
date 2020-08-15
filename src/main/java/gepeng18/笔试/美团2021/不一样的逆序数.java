package gepeng18.笔试.美团2021;

public class 不一样的逆序数 {
    public static void main(String[] args) {
        int n = (int) Math.pow(10,7);
        for(int i=1;i<=n;i++){
            if(judge(i))
                System.out.println(i);

        }
    }
    public static boolean judge(int num){
        String s = new StringBuilder(String.valueOf(num)).reverse().toString();
        if(num*4 == Integer.valueOf(s))
            return true;
        return false;
    }
}
