package gepeng18.sword2offer;

public class 剪绳子 {

    int [] nums = new int[1000];

    public 剪绳子() {
        for(int i=0;i<1000;i++)
            nums[i] = -1;
    }


    public int cutRope(int target) {

        if(target ==1)
            return 1;
        if(nums[target]==-1){
            int max = -1;
            for(int i=1;i<target;i++){
                max = Math.max(cutRope(i)*cutRope(target-i),Math.max(max,i*(target-i)));
            }
            max = Math.max(max,target);
            nums[target]=max;
        }

        return nums[target];
    }



}
