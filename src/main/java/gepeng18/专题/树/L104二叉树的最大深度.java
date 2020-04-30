package gepeng18.专题.树;


/**
 * 这题较为简单，就是左子树的深度和右子树的深度取最大值，再加上1
 */
public class L104二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
