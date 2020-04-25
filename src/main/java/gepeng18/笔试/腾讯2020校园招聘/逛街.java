package gepeng18.笔试.腾讯2020校园招聘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）

 输入描述:
 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 1<=n<=100000;
 1<=wi<=100000;

 输出描述:
 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。


 输入例子1:
 6
 5 3 8 3 2 5

 输出例子1:
 3 3 5 4 4 4

 例子说明1:
 当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
 */

/**
 * 您的代码已保存
 * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
 * case通过率为50.00%
 * 用时:31分钟
 */
public class 逛街 {
    List<Integer> nums = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public void input(){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i=0;i<count;i++)
        {
            nums.add(in.nextInt());
        }
    }

    public void guangjie(){
        if(nums.size()==0)
            return ;

        for(int i=0;i<nums.size();i++){
            //从i开始向前移动
            int currentHeight = 0;
            int sawCount = 0;
            for(int j=i-1;j>=0;j--)
            {
                if(nums.get(j)>currentHeight){
                    sawCount++;
                    currentHeight = nums.get(j);
                }
            }
            currentHeight = 0;
            for(int j=i+1;j<nums.size();j++)
            {
                if(nums.get(j)>currentHeight){
                    sawCount++;
                    currentHeight = nums.get(j);
                }
            }
            result.add(sawCount+1);
        }



    }

    public void output(){
        if(result.size()==0)
            return ;
        for(int i=0;i<result.size()-1;i++)
            System.out.print(result.get(i)+" ");
        System.out.print(result.get(result.size()-1));
    }
    public static void main(String[] args) {
        final 逛街 instance = new 逛街();
        instance.input();
        instance.guangjie();
        instance.output();

    }
}
