package gepeng18.专题.树.遍历;

import java.util.*;

/*
 非递归,二叉树的前序遍历
 时间复杂度: O(n), n为树的节点个数
 空间复杂度: O(h), h为树的高度
 */


public class 非递归层次 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        // queue，用于模拟底层存取数据的
        LinkedList<Command> queue = new LinkedList<>();
        // 把root根节点的信息存进去
        queue.addLast(new Command("go",root));

        //然后对栈中的元素进行判断
        while (!queue.isEmpty()){
            // 栈顶元素
            Command cmd = queue.pollFirst();

            // 判断弹出的栈顶元素是啥
            if(cmd.operation.equals("print")) {
                // return res.add(cmd.node.val);报错 —— 类型不匹配 ，提供的是布尔，需要的是list。。
                res.add(cmd.node.val);
            }else{
                //字符串表示指令是不严谨的，可以用枚举或者boolean
                assert cmd.operation.equals("go");
                // 打印当前节点的信息
                queue.addLast(new Command("print",cmd.node));

                if(cmd.node.left!=null) {
                    //有左子树，往下执行，所以往栈中推入go指令
                    queue.addLast(new Command("go", cmd.node.left));
                }

                // 前序遍历 root -> left ->right，所以推入栈就反过来
                if(cmd.node.right!=null){
                    //有右子树，往下执行，所以往栈中推入go指令
                    queue.addLast(new Command("go",cmd.node.right));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        final List<Integer> integers = new 非递归层次().preorderTraversal(treeNode1);
        for(Integer i:integers)
            System.out.println(i);
    }
}


