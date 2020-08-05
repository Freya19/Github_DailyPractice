package gepeng18.专题.二分查找.林沐.二分查找树;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class 序列化反序列化 {
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

    static void BST_insert(TreeNode node, TreeNode insert_node){
        if (insert_node.val < node.val){
            if (node.left!=null){
                BST_insert(node.left, insert_node);
            }
            else{
                node.left = insert_node;
            }
        }
        else{
            if (node.right!=null){
                BST_insert(node.right, insert_node);
            }
            else{
                node.right = insert_node;
            }
        }
    }


    void BST_preorder(TreeNode node, StringBuilder data){
        if (node == null){
            return;
        }

        data.append(String.valueOf(node.val));
        BST_preorder(node.left, data);
        BST_preorder(node.right, data);
    }

    String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        BST_preorder(root, data);
        return data.toString();
    }
    TreeNode deserialize(String data) {
        if (data.length() == 0){
            return null;
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        String[] split = data.split("#");
        for (String num:split){
            nodes.add(new TreeNode(Integer.valueOf(num)));
        }
        for (int i = 1; i < nodes.size(); i++){
            BST_insert(nodes.get(0), nodes.get(i));
        }
        return nodes.get(0);
    }


    static void preorder_print(TreeNode node, int layer){
        if (node == null){
            return;
        }
        for (int i = 0; i < layer; i++){
            System.out.println("-----");
        }
        System.out.println(node.val);
        preorder_print(node.left, layer + 1);
        preorder_print(node.right, layer + 1);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(15);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        序列化反序列化 solve = new 序列化反序列化();
        String data = solve.serialize(a);
        System.out.println(data);
        TreeNode root = solve.deserialize(data);
        preorder_print(root, 0);
    }
}
