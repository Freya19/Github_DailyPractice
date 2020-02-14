package gepeng18.sword2offer;

public class re {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        return reconstruct(pre, in, 0, in.length-1, 0, in.length-1);

    }


    //给定pre,in,int pleft, int pright, int ileft,int iright 我把这个树给构造出来
    TreeNode reconstruct(int[] pre, int[] in, int pleft, int pright, int ileft, int iright) {

        if (pleft > pright || ileft > iright)
            return null;

        //根
        TreeNode root = new TreeNode(pre[pleft]);

        int index = ileft;
        while (index < iright) {
            if (in[index] == pre[pleft]) {
                break;
            } else
                index++;
        }

        root.left = reconstruct(pre, in, pleft + 1, pleft + index - ileft, ileft, index - 1);
        root.right = reconstruct(pre, in, pleft + index - ileft + 1, pright, index + 1, iright);
        return root;
    }


}









