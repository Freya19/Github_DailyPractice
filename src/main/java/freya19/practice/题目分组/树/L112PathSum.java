package freya19.practice.题目分组.树;

/**
递归 ——
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class L112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        // 一个空的树
        if(root == null) return false;

        // 判断节点是否为叶子节点，如果是的，返回看看其值是否等于sum，若等于就是true，反之false。
        if(root.right==null&&root.left==null)
            return root.val==sum;

        // 如果不是叶子节点，就用递归继续往下走
        if(hasPathSum(root.right,sum-root.val))
            return true;
        /*
        如果root.right 非空，非叶子节点，就还要再调用一次hasPathSum;
        调用中 再判断其左右节点是否为空，是否为叶子节点。。。。。。
        如果root.right一侧都走完了，找到了就返回true；
        （这中间其实有一点感觉：就是递归中 return true; 这里。25、26行和30行的return 感觉。。。
        找不到就继续下面的if语句
        下面的if语句和这里执行过程相同。
         */
        if(hasPathSum(root.left,sum-root.val))
            return true;

        return false;
    }
}
