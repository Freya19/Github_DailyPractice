package gepeng18.专题.二分查找.林沐.二分查找树;

public class 二分查找树的插入 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    void BST_insert(TreeNode node, TreeNode insert_node){
        // 小于插到左边孩子，左孩子有，则递归插入
        if (insert_node.val < node.val){
            if (node.left!=null){
                BST_insert(node.left, insert_node);
            }
            else{
                node.left = insert_node;
            }
        }
        // 大于插右边，右孩子有，则递归插入
        else{
            if (node.right!=null){
                BST_insert(node.right, insert_node);
            }
            else{
                node.right = insert_node;
            }
        }
    }

    void preorder_print(TreeNode node,int layer){
        if (node == null){
            return;
        }
        for (int i = 0; i < layer; i++){
            System.out.println("-----");
        }
        System.out.println(String.format("[%d]\n", node.val));
        preorder_print(node.left, layer + 1);
        preorder_print(node.right, layer + 1);
    }
}
