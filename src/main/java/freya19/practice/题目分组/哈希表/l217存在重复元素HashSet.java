package freya19.practice.题目分组.哈希表;

import java.util.HashSet;

public class l217存在重复元素HashSet {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        //存在重复元素——> set大小比元素组小
        return set.size()< nums.length;
    }
}
