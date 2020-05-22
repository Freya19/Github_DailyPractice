package gepeng18.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 练习树的遍历 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Command {
        public static final String PRINT = "print";
        public static final String GO = "go";

        /*operation*/
        String op;
        TreeNode node;

        public Command(String op, TreeNode node) {
            this.op = op;
            this.node = node;
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        final Stack<Command> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        stack.push(new Command(Command.GO,root));
        while(!stack.isEmpty()){
            Command command = stack.pop();
            if(command.op.equals(Command.PRINT))
                res.add(command.node.val);
            else
            {
                if(command.node.right!=null)
                    stack.push(new Command(Command.GO,command.node.right));

                if(command.node.left!=null)
                    stack.push(new Command(Command.GO,command.node.left));

                stack.push(new Command(Command.PRINT,command.node));
            }
        }
        return res;
    }


}
