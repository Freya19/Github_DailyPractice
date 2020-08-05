package gepeng18.专题.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 跳跃游戏2 {
    int jump(List<Integer> nums) {
        int n = nums.size();
        int preFarthest = 0, curFarthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            // 目前来说，最远能到哪
            curFarthest = Math.max(nums.get(i) + i, curFarthest);
            if (preFarthest == i) {
                jumps++;
                preFarthest = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(Arrays.asList(2,3,1,1,4));
        System.out.println(String.format("%d\n", new 跳跃游戏2().jump(nums)));
    }
}
