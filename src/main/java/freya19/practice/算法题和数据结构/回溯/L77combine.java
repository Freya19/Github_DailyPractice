package freya19.practice.算法题和数据结构.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class L77combine {
    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        LinkedList<Integer> temp = new LinkedList<>();
        //因为C(n,k)，是从1到n之间的数进行组合
        generateCombination(n,k,1,temp);

        return res;
    }

    /** 1...n  之间，从start个数开始找到k个数的组合，temp中存的是前start个组合*/
    private void generateCombination(int n, int k, int start, LinkedList<Integer> temp) {
        // 递归终止
        if (temp.size() == k) {
            res.add((List<Integer>) temp.clone());
            return;
        }

        // 否则就继续从start往后组合

        /*
        // 优化
        // 还有k - c.size()个空位, 所以, [i...n] 中至少要有 k - c.size() 个元素
        // i最多为 n - (k - c.size()) + 1
        for(int i = start ; i <= n - (k - c.size()) + 1 ; i ++){
        */
        for (int i = start; i <= n; i++) {
            temp.addLast(i);
            // i位置的数加入了组合结果中，i后面的数字仍要进行一次判断，看看是否也要加入,此时start+1
            generateCombination(n,k,i+1,temp);
            //走到下面这一步，表示当前这个i=start已经组合完了，要继续i=start+1位置的数字往后组合了
            //所以就要从temp中把存入的i移除
            temp.removeLast();
        }

        return;
    }
}
