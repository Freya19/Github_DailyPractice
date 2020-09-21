package gepeng18.考试.海康;

public class 子序列最小和 {
    public static void main(String[] args) {
        int [] nums = new int[]{-7,6,-5,-9,7};
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<nums.length;i++){
            if (sum>0)
                sum = nums[i];
            else
                sum = sum+nums[i];
            min = Math.min(sum,min);
        }
        System.out.println(min);
    }
}
