/*
给定一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:
给定nums = [3,2,2,3], val = 3,
函数应该返回新的长度2, 并且nums中的前两个元素均为 2。
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,1,2,2,3,0,4,2], val = 2,
函数应该返回新的长度5, 并且nums中的前五个元素为 0, 1, 3, 0, 4。
注意这五个元素可为任意顺序。
你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package freya19.practice.Daily_Practices;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class removeElementL27 {
    public int removeElement(int[] nums, int val){
        if(nums == null) return 0;
        int slow =  0;
        for (int fast = 0;fast<nums.length;fast++){
            if(nums[fast]!= val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int arr[]={2,3,3,2};
        int val = 3;

        //原数组元素
        System.out.print("原数组中元素: ");
        for(int i:arr){
            System.out.print(i);
        }
        System.out.println();

        removeElementL27 re = new removeElementL27();
        int len = re.removeElement(arr,val);
        System.out.println("移除后的数长度："+ len);

        //新数组的排列
        System.out.print("移除后数组中元素: ");
        for(int j:arr){
            System.out.print( j);
        }
        System.out.println();

        //不重复的元素 —— 其实最后显示的数组可以是这样的，因为重复的被移除了
        System.out.println("移除后保留的符合要求的数组元素: ");
        for(int j=0;j<len;j++){
            System.out.print(arr[j]);
        }
    }
}

/*
LeetCode26和27题底下都有着这样的说明：
说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:
// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
    int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

 */