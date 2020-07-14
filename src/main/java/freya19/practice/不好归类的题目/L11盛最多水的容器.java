package freya19.practice.不好归类的题目;
/**
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
 */

public class L11盛最多水的容器 {
    public int maxArea(int[] height) {
        int len = height.length;
        int area = 0;
        if(height==null||len<2) return area;

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int currentHeight=Math.min(height[i],height[j]);
                area= Math.max(area,(j-i)*currentHeight);
            }
        }
        return area;
    }

    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,1};
        L11盛最多水的容器 maxA=new L11盛最多水的容器();
        int c=Math.min(1,1);
        System.out.println(c);
        System.out.println(maxA.maxArea(height));
    }
}
