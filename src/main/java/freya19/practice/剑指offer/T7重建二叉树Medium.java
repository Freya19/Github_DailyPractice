package freya19.practice.剑指offer;

import java.util.Arrays;

public class T7重建二叉树Medium {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = null;

        if (preorder == null || preorder.length == 0) {
            return root;
        }

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
}
