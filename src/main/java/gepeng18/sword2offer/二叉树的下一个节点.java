package gepeng18.sword2offer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class 二叉树的下一个节点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
            return null;


        if(pNode.right!=null){
            TreeLinkNode res = findRightFirst(pNode.right);
            return res;
        }

        while(pNode.next!=null)
        {
            TreeLinkNode proot=pNode.next;
            if(proot.left==pNode)
                return proot;
            pNode=pNode.next;
        }
        return null;

    }

    private TreeLinkNode findRightFirst(TreeLinkNode right) {
        while(right.left!=null){
            right = right.left;
        }
        return right;
    }
}
