package gepeng18.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 输入: [1,8,6,2,5,4,8,3,7]
 输出: 49
 */
public class maxWaterContainerL11 {
    public static void main(String[] args) {
        int []height = {0};
        int result = new SolutionL11().maxArea(height);
        System.out.println(result);
    }
}


class SolutionL11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int maxHeight = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, maxHeight * (right - left));
            if (height[left] > height[right]) {
                right--;

            } else if (height[left] < height[right]) {
                left++;

            } else {
                left++;
                right--;
            }

        }
        return maxWater;
    }
}