package freya19.practice.Daily_Practices;
/*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。

示例:
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
 */

public class L111二叉树最短路径 {
    public int minDepth(TreeNode root) {
        //节点为空，直接返回0；
        if (root == null) return 0;

        //节点的子节点为空，直接返回1
        if (root.left == null && root.right == null)
            return 1;


        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        //有一个子节点为空
        if (root.left == null || root.right == null) {
            return leftMinDepth + rightMinDepth + 1;
        }

        //两个子节点都非空
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }
}
