package gepeng18.专题.二分查找.林沐.相关题目;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 *     如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *
 *
 *
 * 示例：
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *
 *
 *
 * 提示：
 *
 *     letters长度范围在[2, 10000]区间内。
 *     letters 仅由小写字母组成，最少包含两个不同的字母。
 *     目标字母target 是一个小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 普天同庆，我竟然写对了，一次过，完美
 */
public class L744寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0,right = letters.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(letters[mid] == target){
                if(mid == letters.length-1 )
                    return letters[0];
                else if (letters[mid+1]>target)
                    return letters[mid+1];
                left = mid+1;
            }else if(letters[mid] > target){
                if(mid == 0)
                    return letters[0];
                if(letters[mid-1]<target)
                    return letters[mid];
                right = mid - 1;
            }else{
                if(mid == letters.length-1)
                    return letters[0];
                if(letters[mid+1]>target)
                    return letters[mid+1];
                left = mid + 1;
            }
        }
        throw  new RuntimeException();
    }

    public static void main(String[] args) {
        L744寻找比目标字母大的最小字母 solver = new L744寻找比目标字母大的最小字母();
        String find = "acdgjk";
        for (int i=0;i<find.length();i++){
            char c = solver.nextGreatestLetter(new char[]{'c', 'f', 'j'}, find.charAt(i));
            System.out.println(c);
        }
    }
}
