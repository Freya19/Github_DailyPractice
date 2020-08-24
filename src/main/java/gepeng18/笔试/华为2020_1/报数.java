package gepeng18.笔试.华为2020_1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 输入一行两个数，M,N
 * 代表一个二维矩阵的行数和列数
 * 从左上角(0,0)的那个人开始从1，顺时针绕着矩阵外圈报数。然后内圈的情况一样
 * 当报道的数字个位为7并且十位为奇数时，记录下这个人的位置到一个二维结果数组中，结果数组res的尺寸为N*2
 * 注意，当M,N的范围不在闭区间[10,1000]时，返回内容为空的结果数组。
 */

/**
 * 输出格式参考：一定得看
 * https://www.nowcoder.com/discuss/482628?channel=666&source_id=discuss_terminal_discuss_sim
 */
public class 报数 {
    int res[][] ;
    int num;
    int resIndex = 0;
    public boolean judgeCondition(int num){
        // 第一位符合的好像就是17
        if(num<17)
            return false;
        int digit_1 = num%10;
        int digit_2 = num/10%10;
        return digit_1 == 7 && digit_2%2==1;
    }

    public void record(int x,int y){
        num++;
        if (judgeCondition(num)){
            res[resIndex][0] = x;
            res[resIndex][1] = y;
            resIndex++;
        }
    }

    // M行，N列
    public void solve(int M,int N){
        res = new int[N][2];
        int left = 0,right = N-1;
        int  top = 0,bottom = M-1;
        while (left<=right&&top<=bottom){

            for (int i = left;i<=right;i++){
                record(top,i);
            }

            for (int i = top+1;i<=bottom;i++){
                record(i,right);
            }

            if (left!=right){
                for (int i = right-1;i>=left;i--)
                    record(bottom,i);
            }

            if(top!=bottom){
                for (int i = bottom-1;i>=top+1;i--)
                    record(left,i);
            }
            left++;right--;top++;bottom--;
        }
    }

    public static void main(String[] args) {
        int M = 7, N = 7;
        报数 solver = new 报数();
        solver.solve(M,N);
        for (int i =0;i<N;i++)
            System.out.println(Arrays.toString(solver.res[i]));
    }
    // 1 2 3 4 5 6 7 8 9 10
}
