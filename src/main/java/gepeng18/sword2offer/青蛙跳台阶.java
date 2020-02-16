package gepeng18.sword2offer;

public class 青蛙跳台阶 {
    int[] nums ;

    public 青蛙跳台阶() {
        this.nums = new int[100];
        for(int i=0;i<100;i++)
            nums[i] = -1;
    }

    public int jump(int n) {

        if(n == 1){
            nums[1] = 1;
            return 1;
        }

        if(n==2){
            nums[2] = 2;
            return 2;
        }

        if(nums[n] == -1)
            nums[n] = jump(n-2)+jump(n-1);
        return nums[n];

    }


    public static void main(String[] args) {
        new 青蛙跳台阶().jump(20);
    }

}
