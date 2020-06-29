package freya19.practice.leetcode.树;

import freya19.practice.leetcode.树.TreeNode;

/** 递归
给定一个二叉树，找出其最大深度。
最大深度是从根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
public class L104BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        //递归终止条件
        if(root==null) return 0; //这棵树高度为0

        // 递归过程
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        return Math.max(maxLeftDepth,maxRightDepth)+1; // +1是因为索引是从0开始的

    }
}
