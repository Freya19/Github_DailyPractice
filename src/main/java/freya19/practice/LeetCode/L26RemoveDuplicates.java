/*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package freya19.practice.LeetCode;

public class L26RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        if(nums==null||nums.length==0) return 0; //数组为空或长度为0的情况

        int slow = 1;
        for(int fast = 1;fast<nums.length;fast++){
            if(nums[fast-1]!=nums[fast]) {
                nums[slow]=nums[fast];
                slow++;
            }
        }return slow;
    }

    public static void main(String[] args) {
        int arrs[]={1,1,2,2,2,3};
//        int arrs[]={};
//        int arrs[]=null;//这样会报错：Exception in thread "main" java.lang.NullPointerException
        //原数组
        for(int i:arrs){
            System.out.print(i);
        }
        System.out.println();
        //移除重复元素，返回移除后不重复元素数组的长度
        L26RemoveDuplicates rd = new L26RemoveDuplicates();
        int l=rd.removeDuplicates(arrs);
        System.out.println(l);

        //新数组的排列
        for(int j:arrs){
            System.out.print(j);
        }
        System.out.println();

        //不重复的元素 —— 其实最后显示的数组可以是这样的，因为重复的被移除了
        for(int j=0;j<l;j++){
            System.out.print(arrs[j]);
        }

    }
}

