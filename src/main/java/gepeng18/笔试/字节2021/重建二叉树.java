package gepeng18.笔试.字节2021;

import gepeng18.专题.树.TreeNode;

import java.util.Arrays;

public class 重建二叉树 {
    private int findInorderIndex(int [] preorder,int [] inorder){
        int firstNum = preorder[0];
        for (int i = 0;i<inorder.length;i++){
            if(inorder[i] == firstNum)
                return i;
        }
        throw  new RuntimeException("不可能出现");
    }
    public TreeNode buildTree(int [] preorder, int[] inorder){
        if(preorder != null && preorder.length == 0)
            return null;
        TreeNode root = null;
        root = new TreeNode();
        root.val = preorder[0];
        int index = findInorderIndex(preorder, inorder);

        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),
                Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),
                Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }
}
