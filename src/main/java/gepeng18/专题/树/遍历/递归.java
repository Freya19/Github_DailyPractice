package gepeng18.专题.树.遍历;

public class 递归 {
    void preorder(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}
