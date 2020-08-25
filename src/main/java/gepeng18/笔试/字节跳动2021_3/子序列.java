package gepeng18.笔试.字节跳动2021_3;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 子序列 {
    long sum = 0;
    // 1
    public void back(int [] nums, int k, int start, List<Integer> state){
        if(start > nums.length){
            return ;
        }

        for (int i = 0;i<state.size();i++){
            for (int j =i+1;j<state.size();j++){
                if ((state.get(i)+state.get(j) )%k==0)
                    return;
            }
        }
        System.out.println(state);
        sum++;

        for (int i = start; i < nums.length; i++) {
            List<Integer> tmpState = new ArrayList(state);
            tmpState.add(nums[i]);
            back(nums, k, i + 1,tmpState);
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numsLength = input.nextInt();
        int[] nums = new int[numsLength];
        int target = input.nextInt();

        for (int i = 0; i < numsLength; i++) {
            nums[i] = input.nextInt();
        }
        子序列 solver = new 子序列();

        solver.back(nums,target,0,new ArrayList<>());
        System.out.println(solver.sum);
    }
}
