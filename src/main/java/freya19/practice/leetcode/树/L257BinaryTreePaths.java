package freya19.practice.leetcode.树;

import freya19.practice.leetcode.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。

示例:
输入:
   1
 /   \
2     3
 \
  5
输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class L257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();

        if(root == null)  return res;

        // 叶子节点
        if(root.left==null&&root.right==null) {
                res.add(Integer.toString(root.val));  // Integer.toString(root.val) 将整型转成字符型
                return res;
        }

        // 非叶子节点
        List<String> leftString = binaryTreePaths(root.left);
        for(String ls:leftString){ // 将结果做显示
            StringBuilder sbl = new StringBuilder(Integer.toString(root.val));
            sbl.append("->");
            sbl.append(ls);
            res.add(sbl.toString());
            // res.add(Integer.toString(root.val)+"->"+ls);  // 这样写也可以，但是耗时很长（时间复杂度可能比较大？？）

        }

        List<String> rightString = binaryTreePaths(root.right);
        for(String rs:rightString){ // 将结果做显示
            StringBuilder sbr = new StringBuilder(Integer.toString(root.val));
            sbr.append("->");
            sbr.append(rs);
            res.add(sbr.toString());
            // res.add(Integer.toString(root.val)+"->"+rs); // 这样写也可以，但是耗时很长（时间复杂度可能比较大？？）
        }

        return res;
    }

}
