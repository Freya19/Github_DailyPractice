package freya19.practice.SwordToOffer;
/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建二叉树并返回。

递归
 */

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class p62reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return consTructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    // 除了前序和中序遍历的数组之外，还需要两个数组头尾的两个索引，才能找到根节点。
    public TreeNode consTructBinaryTree(int [] pre,int [] in,int pleft, int pright, int ileft, int iright){

        if(pleft>pright||ileft>iright) return null;

        // 首先找到前序和中序遍历数组中的根节点，从而确定左右子树
        // 前序遍历的根节点 —— 前序遍历数组中的第一个元素对应的节点就是根节点
        TreeNode root = new TreeNode(pre[pleft]);
        //找张旭遍历中根节点的位置 —— 找到值和root值相等的节点
        int index = ileft;
        while (index < iright){
            if(in[index]==root.val) break;
            else index++;
        }

        // 找到了前序和中序遍历中的根节点，也就是将这个两个数组中的左右子树区域划分好了
        // 利用递归构建根节点的左子树：
        root.left = consTructBinaryTree(pre, in, pleft+1, pleft+index-ileft, ileft,index-1);
        // 利用递归构建根节点的右子树：
        root.right= consTructBinaryTree(pre, in, pleft+index-ileft+1, pright, index+1,iright);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        p62reConstructBinaryTree bt = new p62reConstructBinaryTree();
        bt.reConstructBinaryTree(pre,in);
    }

}
