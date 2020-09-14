package gepeng18.考试.美团;

public class 换饮料 {
    public static int solve(int n){
        int sum = 0;
        int bottle = 0;
        // 饮料大于0并且瓶子>2才行
        while (n>0||bottle>2){
            // 饮料喝完了
            sum += n ;
            // 来了n个瓶子
            bottle+= n;
            // 瓶子又换了n瓶饮料
            n = bottle/3;
            // 还剩几个瓶子
            bottle = bottle-n*3;
        }
        return sum;
    }

    public static void main(String[] args) {
        int solve = solve(5);
        System.out.println(solve);
    }
}
