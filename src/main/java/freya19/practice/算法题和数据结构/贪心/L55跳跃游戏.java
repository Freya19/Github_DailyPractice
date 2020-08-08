package freya19.practice.算法题和数据结构.贪心;

public class L55跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        // 每个位置处的 可以跳到的位置
        int[] position = new int[nums.length];
        for (int i = 0; i < position.length; i++) {
            position[i] = i + nums[i];
        }

        int jump = 0;
        int maxDistance = position[0];
        // 如果jump大于maxDistance，就超过了这个 i可以跳到的 位置了
        while (jump < position.length && jump <= maxDistance) {
            // 更新 maxDistance
            if (maxDistance < position[jump]) {
                maxDistance = position[jump];
            }
            jump++;
        }

        // 如果最终的 jump 正好是 position 的末尾，那就 可以跳到
        // 暗含 上面的position数内的可以调至的位置满足跳跃到最后的条件
        return jump == position.length;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new L55跳跃游戏().canJump(nums));
    }
}
