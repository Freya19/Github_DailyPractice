package gepeng18.专题.树;

import java.util.Arrays;

public class T7重建二叉树Medium {
    private int num = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = null;
        int rootVal = preorder[0];
        root = new TreeNode();
        root.val = rootVal;

        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));

        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
    public void findLeaves(TreeNode root){
        if(root  ==null){
          return ;
        }
        if (root.left == null && root.right == null) {
            num++;
            return ;
        }
        findLeaves(root.left);
        findLeaves(root.right);
    }
}
