package gepeng18.leetcode;

import javafx.util.Pair;

import java.util.*;

public class L102二叉树的层次遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        queue.addLast(new Pair<>(root, 0));
        while(!queue.isEmpty()){
            final Pair<TreeNode, Integer> poll = queue.removeFirst();
            TreeNode node = poll.getKey();
            Integer level = poll.getValue();
            if(res.size()==level)
                res.add(new ArrayList<>());
            res.get(level).add(node.val);
            if(node.left!=null)
                queue.addLast(new Pair<>(node.left, level + 1));
            if(node.left!=null)
                queue.addLast(new Pair<>(node.right, level + 1));

        }
        return res;
    }
}
