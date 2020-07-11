package freya19.practice.题目分组.哈希表;

import gepeng18.专题.哈希表.L128最长连续序列;

import java.util.HashMap;

/**
 * hard
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 */
public class l128最长连续序列NICE {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }

        HashMap<Integer, Integer> cntMap = new HashMap<>();
        //将数组中的元素加入map中，key为元素，value初始都为1
        for (int num : nums) {
            cntMap.put(num, 1);
        }

        //然后对每个元素进行连续序列寻找并记录（调用递归函数forward）
        for (int num : nums) {
            forward(cntMap, num);
        }
        //找到后，再找最大值
        return maxValue(cntMap);
    }

    private int maxValue(HashMap<Integer, Integer> cntMap) {
        int maxNum=0;
        for(int num:cntMap.keySet()){
            maxNum=Math.max(maxNum,cntMap.get(num));
        }
        return maxNum;
    }

    private int forward(HashMap<Integer, Integer> cntMap, int num) {
        if (!cntMap.containsKey(num)) {
            return 0;
        }

        int cnt = cntMap.get(num);
        if (cnt > 1) {
            return cnt;
        }

        //否则继续对下一个相邻元素进行连续序列的寻找
        cnt = forward(cntMap, num + 1) + 1;
        //最后将找到的以num为首的子序列长度cnt存入map
        cntMap.put(num,cnt);

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4000,4,200,1,3,2};
        int longest = new L128最长连续序列().longestConsecutive(nums);
        System.out.println(longest);
    }
}
