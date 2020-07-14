package freya19.practice.算法题和数据结构.数组和矩阵;

import java.util.HashMap;

public class L697数组的度 {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> numFreq = new HashMap<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        HashMap<Integer, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
            lastIndex.put(num, i);
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
        }

        int maxFreq = 0;
        for (int num : numFreq.keySet()) {
            maxFreq = Math.max(maxFreq, numFreq.get(num));

        }

        int minDistance = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (numFreq.get(nums[i]) == maxFreq) {
                minDistance= Math.min(minDistance,lastIndex.get(nums[i])-firstIndex.get(nums[i])+1);
            }

        }

        return minDistance;
    }
}
