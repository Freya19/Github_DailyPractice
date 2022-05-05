package gepeng18.leetcode.old;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L103二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
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



        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < oriRes.size(); i++) {

            if(i%2==0)
                res.add(oriRes.get(i));
            else{
                for (int j = 0; j < oriRes.get(i).size(); j++) {
                    stack.push(oriRes.get(i).get(j));
                }
                final ArrayList<Integer> list = new ArrayList<>();

                for (int j = 0; j < oriRes.get(i).size(); j++) {
                    list.add(stack.pop());
                }
                res.add(list);
            }
        }

        return res;
    }
}
