package gepeng18.sword2offer;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        final TreeNode root = reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;

    }

    //给定两个数组 pleft-pright  ileft---- index -----iright
    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int pleft, int pright, int ileft, int iright) {

        if(pleft>pright||ileft>iright)
            return null;
        //第一个节点就是根
        TreeNode root = new TreeNode(pre[pleft]);
        int index = ileft;
        while(index<in.length){
            //如果找到根了则不找了，否则继续找
            if(in[index] == pre[pleft])
                break;
            else
                index++;
        }
        //先重建左边的
        root.left = reConstructBinaryTree(pre,in,pleft+1,pleft+index-ileft,ileft,index-1);
        //再重建右边的

        //再一起重建
        root.right = reConstructBinaryTree(pre,in,pleft+index-ileft+1,pright,index+1,iright);
        return root;

    }
}
