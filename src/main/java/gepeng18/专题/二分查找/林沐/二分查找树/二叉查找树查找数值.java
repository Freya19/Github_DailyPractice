package gepeng18.专题.二分查找.林沐.二分查找树;

public class 二叉查找树查找数值 {
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

    static boolean BST_search(TreeNode node, int value) {
        if (node.val == value) {
            return true;
        }
        if (value < node.val) {
            if (node.left != null) {
                return BST_search(node.left, value);
            } else {
                return false;
            }
        } else {
            if (node.right != null) {
                return BST_search(node.right, value);
            } else {
                return false;
            }
        }
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
        for (int i = 0; i < 20; i++) {
            if (BST_search(a, i)) {
                System.out.println(String.format("%d is in the BST.\n", i));
            } else {
                System.out.println(String.format("%d is not in the BST.\n", i));
            }
        }
    }

}