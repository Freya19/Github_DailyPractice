package gepeng18.专题.回溯;

public class 比赛次数 {
    public static int solve(int a,int b){
        if (a == 0  && b == 0)
            return 0;
        if (a<0 || b<0)
            return Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int res1 = solve(a - 3, b) + 1;
        if (res1>=0){
            min = Math.min(min,res1);
        }
        int res2 = solve(a, b-3) + 1;
        if (res2>=0){
            min = Math.min(min,res2);
        }
        int res3 = solve(a-1, b-1) + 1;
        if (res3>=0){
            min = Math.min(min,res3);
        }
        // 换到了吗？换到了则返回，换不到则返回-1
        return (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
    }

    public static void main(String[] args) {
        int solve = solve(3, 0);
        System.out.println(solve);
    }
}
