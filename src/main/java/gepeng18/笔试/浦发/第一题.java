package gepeng18.笔试.浦发;

import java.util.*;

public class 第一题 {
    public static ArrayList<Integer> splits (String input){
        ArrayList<Integer> nums = new ArrayList<>();
        int num = 0;
        for (int index=1;input.charAt(index)!=']';index++){
            if (input.charAt(index) == ',') {
                nums.add(num);
                num = 0;
            } else{
                num=num*10+input.charAt(index)-'0';
            }
        }
        nums.add(num);
        return nums;
    }


    public  static List<Integer> compute(List<Integer> list,Integer num){
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (Integer i:list)
            hashmap.put(i,hashmap.getOrDefault(i,0)+1);

        ArrayList<Map.Entry<Integer, Integer>> nums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            nums.add(entry);
        }
        for(int i =0;i<nums.size();i++){
            int minIndex=i;
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(j).getValue()>nums.get(minIndex).getValue())
                    minIndex=j;
            }
            Map.Entry<Integer, Integer> tmp=nums.get(minIndex);
            nums.set(minIndex,nums.get(i));
            nums.set(i,tmp);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        while (num-->0){
            res.add(nums.get(index).getKey());
            index++;
        }
        return res;
    }

    public  static void solve(String input){
        StringBuilder first = new StringBuilder();
        int i;
        for ( i = 0;i<input.length();i++){
            if (input.charAt(i) == ']') {
                first.append(input.charAt(i));
                break;
            }
            first.append(input.charAt(i));
        }
        StringBuilder second = new StringBuilder();
        for (int j = i+2;j<input.length();j++)
            second.append(input.charAt(j));
        ArrayList<Integer> nums = splits(first.toString());
        List<Integer> res = compute(nums, Integer.valueOf(second.toString()));
        System.out.println(res);
    }

    public static void main(String[] args) {
        solve("[3,4,2,2,1,1,1,1],2");

    }
}
