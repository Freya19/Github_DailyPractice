package gepeng18.专题.动态规划;

public class 变态跳台阶 {
    int[] nums;

    public 变态跳台阶() {
        this.nums = new int[100];
        for (int i = 0; i < 100; i++)
            nums[i] = -1;
    }

    public int jump(int n) {

        if (n == 1) {
            nums[1] = 1;
            return 1;
        }

        if (n == 2) {
            nums[2] = 2;
            return 2;
        }

        if (nums[n] == -1) {
            //n分为几种情况（假设n为5）  0跳5级  1跳4级 .... 4跳1级  所以是1+jump(1)+jump(2)+....+jumpy(4)
            int sum = 1;
            for (int i = 1; i < n; i++) {
                sum += jump(i);
            }
            nums[n] = sum;

        }

        return nums[n];

    }

    public static void main(String[] args) {
        new 变态跳台阶().jump(20);
    }
}
