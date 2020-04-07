package freya19.practice.LeetCode;
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:
输入: [0,1,0,3,12]    输出: [1,3,12,0,0]

说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
 */

public class L283移动零 {
    public void moveZeroes(int[] nums) {
        //这个方法比我的好了不知道多少倍。。。。。垃圾的我。。。。。主要还是被所谓的双索引搞晕了。。。。哎
        int index=0;
        for(int num :nums){
            if(num!=0){
                nums[index]=num;
                index++; // index记录了不为0的元素，并且赋值给了数组中的0~index个元素
            }
        }

        while (index<nums.length){
            //从index开始往后的元素都赋值为0
            nums[index]=0;
            index++;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 3, 2};
//        int[] nums = {0, 1, 0, 3, 12};
        L283移动零 l283 = new L283移动零();
        l283.moveZeroes(nums);

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
