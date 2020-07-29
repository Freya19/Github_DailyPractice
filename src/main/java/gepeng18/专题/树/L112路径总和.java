package gepeng18.专题.树;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 */
public class L112路径总和 {
    //找以root为根的路径和是否为sum
    public boolean hasPathSum(TreeNode root, int sum) {
        // 叶子就涉及两步
        if(root==null)
            return false;

        if(root.left==null&&root.right==null)
            return sum==root.val;

        return hasPathSum(root.left,sum-root.val) | hasPathSum(root.right,sum-root.val);
    }
}
