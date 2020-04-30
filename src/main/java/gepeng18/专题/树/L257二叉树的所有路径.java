package gepeng18.专题.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */
public class L257二叉树的所有路径 {
    //返回从root到叶子节点的所有路径
    public List<String> binaryTreePaths(TreeNode root) {

        if(root==null)
            return new ArrayList<>();

        //是叶子则返回本数字
        if(root.left==null&&root.right==null){
            ArrayList<String> res = new ArrayList<>();
            res.add(String.valueOf(root.val));
            return res;
        }

        //其实就是自己加上左节点的路径，已经自己加上右节点的路径
        List<String> res = new ArrayList<>();
        List<String> leftPaths = binaryTreePaths(root.left);
        for(String s:leftPaths){
            res.add(root.val+"->"+s);
        }
        List<String> rightPaths = binaryTreePaths(root.right);
        for(String s:rightPaths){
            res.add(root.val+"->"+s);
        }
        return res;
    }

}
