package gepeng18.leetcode.old;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L107二叉树的层次遍历 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> oriRes = new ArrayList<>();
        if(root==null)
            return oriRes;

        queue.addLast(new Pair<>(root, 0));
        while(!queue.isEmpty()){
            final Pair<TreeNode, Integer> poll = queue.removeFirst();
            TreeNode node = poll.getKey();
            Integer level = poll.getValue();
            if(oriRes.size()==level)
                oriRes.add(new ArrayList<>());
            oriRes.get(level).add(node.val);
            if(node.left!=null)
                queue.addLast(new Pair<>(node.left, level + 1));
            if(node.right!=null)
                queue.addLast(new Pair<>(node.right, level + 1));

        }

        for (int i = 0; i < oriRes.size(); i++) {
            stack.push(oriRes.get(i));
        }
        List<List<Integer>> res = new ArrayList<>();
        while(!stack.isEmpty())
            res.add(stack.pop());
        return res;


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        final List<List<Integer>> lists = new L107二叉树的层次遍历().levelOrderBottom(root);
        System.out.println(lists);
    }
}
