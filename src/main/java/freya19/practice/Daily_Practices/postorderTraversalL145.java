package freya19.practice.Daily_Practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
//Definition for a binary tree node.
class TreeNode {
    int val;
    freya19.practice.Daily_Practices.TreeNode left;
    freya19.practice.Daily_Practices.TreeNode right;
    TreeNode(int x) { val = x; }
}

class Command{
    String s;
    freya19.practice.Daily_Practices.TreeNode node;
    public Command(String s, freya19.practice.Daily_Practices.TreeNode node){  //  public
        this.s=s;
        this.node=node;
    }
}
*/

public class postorderTraversalL145 {
    public List<Integer> preorderTraversal(freya19.practice.Daily_Practices.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        // stack，用于模拟底层存取数据的
        Stack<freya19.practice.Daily_Practices.Command> stack = new Stack<>();
        // 把root根节点的信息存进去
        stack.push(new freya19.practice.Daily_Practices.Command("go",root));

        //然后对栈中的元素进行判断
        while (!stack.isEmpty()){
            freya19.practice.Daily_Practices.Command cmd = stack.pop(); // 栈顶元素

            // 判断弹出的栈顶元素是啥
            if(cmd.s.equals("print")) {
                res.add(cmd.node.val);  // return res.add(cmd.node.val);报错 —— 类型不匹配 ，提供的是布尔，需要的是list。。
            }else{
                assert cmd.s.equals("go"); //字符串表示指令是不严谨的，可以用枚举或者boolean

                // 后序遍历   left -> right -> root ，所以推入栈就反过来
                stack.push(new freya19.practice.Daily_Practices.Command("print",cmd.node));

                if(cmd.node.right!=null){ //有右子树，往下执行，所以往栈中推入go指令
                    stack.push(new freya19.practice.Daily_Practices.Command("go",cmd.node.right));
                }

                if(cmd.node.left!=null) { //有左子树，往下执行，所以往栈中推入go指令
                    stack.push(new freya19.practice.Daily_Practices.Command("go", cmd.node.left));
                }
            }
        }
        return res;
    }
}