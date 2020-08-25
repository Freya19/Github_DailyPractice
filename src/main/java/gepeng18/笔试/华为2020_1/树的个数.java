package gepeng18.笔试.华为2020_1;

/**
 * 输入为两行
 * 第一行：N 代表树的节点个数
 * 第二行：N个数字，每个数字为节点的深度（你没看错，原样表述就是这样）
 * 输出：满上上述条件的二叉树的个数，结果(%(10^9+7))
 * 举例：
 * 输入
 * 4
 * 1 0 2 2
 * 输出
 * 2
 *
 * 二叉树有4个节点
 * 有一个节点的深度为1，有一个节点的深度为0，有2个节点的深度为2
 * 可能的二叉树如下：
 * https://www.nowcoder.com/discuss/482638?type=post&order=time&pos=&page=1&channel=-2&source_id=search_post
 */

/**
 * 大致思路；
 * 1. 统计每一层的元素个数
 * 2. 每一层的元素个数不能大于上一层的两倍，所以这一层的元素实际应为 min(上一层两倍，本层给定元素)
 * 3. 根据上层元素求出本层元素的可放位置，如上一层元素为6，则本层可以放12个位置，而如果只有3个节点，则本层
 *    的可能性为C 3 12  ，从12个节点中抽出3个
 * 4. 每一层的组合数相乘即可
 */
public class 树的个数 {

    public static long fact(long n) {
        long sum=1;
        for(int i=2; i<=n; i++) {
            sum*=i;
        }
        return sum;
    }

    public long computeCombin(int base,int num){
        long ans1 = fact(base);
        long ans2 = (fact(num)*(fact(base-num)));
        return ans1/ans2;
    }
    public long solve(int [] deeps_1){
        int sum = 1;
        // 2. 开始进行过滤
        int index = 0;
        for (  index = 1;index<1000;index++){
            if(deeps_1[index] == 0)
                break;
            deeps_1[index] = Math.min(deeps_1[index-1]*2,deeps_1[index]);
        }
        // 3. 求组合数的乘积
        // 这里默认根节点个数为1了，所以main里要判断
        for (int i =1;i<index;i++){
            sum *= computeCombin(deeps_1[i-1]*2,deeps_1[i]);
        }
        return sum;

    }

    public static void main(String[] args) {
        int [] input = new int[]{1,0,2,2};
        // 1. 统计每层节点出现的个数
        int [] deeps_1 = new int[1000];
        for (int i = 0;i<input.length;i++){
            deeps_1[input[i]] ++;
        }
        if(deeps_1[0] !=1) {
            System.out.println(0);
            return ;
        }
        树的个数 solver = new 树的个数();
        long res = solver.solve(deeps_1);
        System.out.println(res);
    }
}
