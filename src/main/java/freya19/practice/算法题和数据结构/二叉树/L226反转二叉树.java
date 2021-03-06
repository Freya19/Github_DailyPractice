package freya19.practice.算法题和数据结构.二叉树;
/*
递归 — —
  翻转一棵二叉树。

示例：
输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class L226反转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 将左子节点反转
        TreeNode left = invertTree(root.left);
        // 将右子节点反转
        TreeNode right = invertTree(root.right);

        // 交换左右节点（C++中用的是swap，但是java中好像没有这个方法）
        root.left = right;
        root.right = left;

        return root;

    }
}
