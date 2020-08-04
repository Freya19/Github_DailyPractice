package gepeng18.专题.贪心;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 跳跃游戏 {
    boolean canJump(List<Integer> nums) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++){
            index.add(i + nums.get(i));
        }
        int jump = 0;
        int max_index = index.get(0);
        while(jump < index.size() && jump <= max_index){
            if (max_index < index.get(jump)){
                max_index = index.get(jump);
            }
            jump++;
        }
        // jump == index.size()时就截止了，所以跳出循环
        if (jump >= index.size()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(Arrays.asList(2,3,1,1,4));
        System.out.println(String.format("%d\n", new 跳跃游戏().canJump(nums)));
    }
}
