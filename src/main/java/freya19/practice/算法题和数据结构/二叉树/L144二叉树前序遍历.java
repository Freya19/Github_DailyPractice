package freya19.practice.算法题和数据结构.二叉树;
/*
 非递归,二叉树的前序遍历
 时间复杂度: O(n), n为树的节点个数
 空间复杂度: O(h), h为树的高度
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Command{
    String s;
    TreeNode node;
    public Command(String s, TreeNode node){  //  public
        this.s=s;
        this.node=node;
    }
}

public class L144二叉树前序遍历 {
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
            Command cmd = stack.pop(); // 栈顶元素

            // 判断弹出的栈顶元素是啥
            if(cmd.s.equals("print")) {
                res.add(cmd.node.val);  // return res.add(cmd.node.val);报错 —— 类型不匹配 ，提供的是布尔，需要的是list。。
            }else{
                assert cmd.s.equals("go"); //字符串表示指令是不严谨的，可以用枚举或者boolean
                // 前序遍历 root -> left ->right，所以推入栈就反过来
                if(cmd.node.right!=null){ //有右子树，往下执行，所以往栈中推入go指令
                    stack.push(new Command("go",cmd.node.right));
                }
                if(cmd.node.left!=null) { //有左子树，往下执行，所以往栈中推入go指令
                    stack.push(new Command("go", cmd.node.left));
                }
                // 无右，无左，就打印当前节点的信息
                stack.push(new Command("print",cmd.node));
            }
        }
        return res;
    }

}


