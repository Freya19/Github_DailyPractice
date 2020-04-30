package gepeng18.专题.树;

public class L226翻转二叉树 {
    //递归调换左子树和右子树的位置，并返回该节点
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
