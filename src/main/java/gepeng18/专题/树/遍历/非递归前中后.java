package gepeng18.专题.树.遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 非递归,二叉树的前序遍历
 时间复杂度: O(n), n为树的节点个数
 空间复杂度: O(h), h为树的高度
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Command{
    String operation;
    TreeNode node;
    public Command(String operation, TreeNode node){  //  public
        this.operation = operation;
        this.node=node;
    }
}

public class 非递归前中后 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        // stack，用于模拟底层存取数据的
        Stack<Command> stack = new Stack<>();
        // 把root根节点的信息存进去
        stack.push(new Command("go",root));

        //然后对栈中的元素进行判断
        while (!stack.isEmpty()){
            // 栈顶元素
            Command cmd = stack.pop();

            // 判断弹出的栈顶元素是啥
            if(cmd.operation.equals("print")) {
                // return res.add(cmd.node.val);报错 —— 类型不匹配 ，提供的是布尔，需要的是list。。
                res.add(cmd.node.val);
            }else{
                //字符串表示指令是不严谨的，可以用枚举或者boolean
                assert cmd.operation.equals("go");
                // 前序遍历 root -> left ->right，所以推入栈就反过来
                if(cmd.node.right!=null){
                    //有右子树，往下执行，所以往栈中推入go指令
                    stack.push(new Command("go",cmd.node.right));
                }
                if(cmd.node.left!=null) {
                    //有左子树，往下执行，所以往栈中推入go指令
                    stack.push(new Command("go", cmd.node.left));
                }

                stack.push(new Command("print",cmd.node));
            }
        }
        return res;
    }

}


