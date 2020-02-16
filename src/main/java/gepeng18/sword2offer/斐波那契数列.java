package gepeng18.sword2offer;

public class 斐波那契数列 {
    int [] nums ;

    public 斐波那契数列() {
        this.nums = new int[100];
        for(int i=0;i<100;i++){
            nums[i] = -1;
        }
    }

    //傻逼做法
    /**
    private static int fibnaqi(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibnaqi(n-2)+fibnaqi(n-1);

    }*/

    //进阶一：
    /*
    private int fibnaqi(int n) {
        if(n==0){
            nums[0] = 0;
            return 0;
        }

        if(n==1){
            nums[1] = 0;
            return 1;
        }
        if(nums[n]==-1)
            nums[n] = fibnaqi(n-2)+fibnaqi(n-1);
        return nums[n];

    }*/

    //进阶二：

    private int fibnaqi(int n) {
        int prepre = 0;
        int pre = 1;
        int res = 0;
        for(int i=2;i<=n;i++){
            res = prepre+pre;

            prepre = pre;
            pre = res;
        }
        if(n==1)
            return pre;
        if(n==0)
            return prepre;
        return res;

    }

    public static void main(String[] args) {
        int n=40;
        int res = new 斐波那契数列().fibnaqi(n);
        System.out.println(res);
    }


}
