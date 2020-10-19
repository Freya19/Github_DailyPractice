package gepeng18.笔试.浦发;

import java.util.*;

public class 和为1 {
    // 字符串处理函数
    public static ArrayList<Integer> str2nums(String input){
        ArrayList<Integer> nums = new ArrayList<>();
        int num = 0;
        boolean negative = false;
        for (int index=1;input.charAt(index)!=']';index++){
            if (input.charAt(index) == ',') {
                if (negative == true)
                    num = num*(-1);
                nums.add(num);
                num = 0;
                negative = false;
            } else{
                if (input.charAt(index)=='-')
                    negative = true;
                else if (input.charAt(index)=='+')
                    negative = false;
                else
                    num=num*10+input.charAt(index)-'0';
            }
        }
        nums.add(num);
        return nums;
    }

    // 排序函数
    public static List<Integer> sort(List<Integer> nums){
        for(int i =0;i<nums.size();i++){
            int minIndex=i;
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(j)<nums.get(minIndex))
                    minIndex=j;
            }
            int tmp=nums.get(minIndex);
            nums.set(minIndex,nums.get(i));
            nums.set(i,tmp);
        }
        return nums;
    }

    public static List<List<Integer>> threeSum(int[] nums,int sum) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = sum-nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = -2, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

    public static int MyIndexOf(String s,char c){
        for (int i = 0;i<s.length();i++)
            if (s.charAt(i) == c) {
                return i;
            }
        return -1;
    }

    public static String MySubString(String s,int start,int end){
        if (end>s.length())
            end = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0;i<s.length();i++)
            if (i>=start&&i<end) {
                res.append(s.charAt(i));
            }
        return res.toString();
    }

    // 假设输入是[1,2,3,4,5],2
    public  static  List<List<Integer>> solve(String input){
        int end = MyIndexOf(input,']');
        String first = MySubString(input, 0, end+1);  // 将[1,2,3,4,5]取出来，end+1最后一位是end
        String second = MySubString(input, end+2, input.length()); // 将[1,2,3,4,5]取出来
        ArrayList<Integer> nums = str2nums(first);
        List<Integer> sort = sort(nums);
        int[] array = new int[sort.size()];
        for (int j = 0;j< array.length;j++)
            array[j] = sort.get(j);
        List<List<Integer>> res = threeSum(array,1);
        return  res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();

        List<List<Integer>> res = solve(s);

        System.out.println(res);
    }
}
