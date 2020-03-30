package freya19.practice.LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */
public class L102BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //最终返回的结果集
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res; //传入的二叉树是个空的树，就返回啥也没有的结果集

        //如果非空，则利用队列来遍历每一层的数据，存放到队列中
        LinkedList<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        // 将root的信息存入.ListNode表示节点，Integer表示是当前节点的层级
        queue.addLast(new Pair<TreeNode,Integer>(root,0));  //addLast;

        //
        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> front = queue.removeFirst(); //队首的元素
            TreeNode node = front.getKey(); // Pair<TreeNode,Integer>中的节点
            Integer level = front.getValue(); // Pair<TreeNode,Integer>中的层级

            if(level==res.size()){ // 层级等于res的大小，表示要再res中新建新的一层；
                // 同一级第二次循环到这儿的时候，level要比size大了，下面一行新建就不用执行了，
                // 直接到下面：将queue中取出来的数据存到res中。此时level是相同的，
                // 所以也就是继当前的ArrayList<Integer>往后存
                res.add(new ArrayList<Integer>());
            }

            assert level<res.size(); // 层级不能比res的大小 小

            //将queue中取出来的数据存到res中
            res.get(level).add(node.val); // level层对应的节点的值

            // 再看看当前这个节点的子节点是否存在，存在的话
            // 将子节点的数据存到队列中，然后再执行循环开始的取和存操作
            if(node.left!=null)
                queue.addLast(new Pair<>(node.left,level+1));
            if(node.right!=null)
                queue.addLast(new Pair<>(node.right,level+1));
        }
        return res;
    }
}
