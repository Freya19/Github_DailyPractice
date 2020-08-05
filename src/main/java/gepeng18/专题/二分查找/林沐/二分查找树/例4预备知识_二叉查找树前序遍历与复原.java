package gepeng18.专题.二分查找.林沐.二分查找树;

import gepeng18.test.java设计.整体设计.List;

import java.util.ArrayList;

public class 例4预备知识_二叉查找树前序遍历与复原 {
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

    static void preorder_print(TreeNode node,int layer){
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


    static void collect_nodes(TreeNode node, ArrayList node_vec){
        if (node == null){
            return;
        }
        node_vec.add(node);
        collect_nodes(node.left, node_vec);
        collect_nodes(node.right, node_vec);
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
        ArrayList<TreeNode> node_vec = new ArrayList<>();
        collect_nodes(a, node_vec);
        for (int i = 0; i < node_vec.size(); i++){
            node_vec.get(i).left = null;
            node_vec.get(i).right = null;
        }
        for (int i = 1; i < node_vec.size(); i++){
            BST_insert(node_vec.get(0), node_vec.get(i));
        }
        preorder_print(node_vec.get(0), 0);
    }
}
