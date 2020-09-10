package freya19.practice.算法题和数据结构.二叉树;

import java.util.*;

public class L105从前序与中序遍历序列构造二叉树 {
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
            if (rootVal == inorder[i]) {
                index = i;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    public void print(TreeNode root, List<Integer> list){
        if(root!=null){
            print(root.left,list);
            print(root.right,list);
            list.add(root.val);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pre = new int[]{1,2,3,4,5,6,7,8};
        int[] post = new int[]{3,2,5,4,1,7,6,8};

        L105从前序与中序遍历序列构造二叉树 solver = new L105从前序与中序遍历序列构造二叉树();
        TreeNode root = solver.buildTree(pre, post);
        ArrayList<Integer> res = new ArrayList<>();
        solver.print(root,res);
        System.out.println(res);

    }
}
