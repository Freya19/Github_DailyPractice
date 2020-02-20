package freya19.practice.Daily_Practices;

import com.sun.org.apache.regexp.internal.RE;
import sun.reflect.generics.tree.Tree;

import java.security.PrivateKey;

/*
给定一个二叉树，它的每个结点都存放着一个整数值。
找出路径和等于给定数值的路径总数。
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
返回 3。和等于 8 的路径有:
1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
 */
public class L437BinaryTreePathSum {
    public int pathSum(TreeNode root, int sum) {
        //以root为根节点的二叉树，寻找和为sum的路径，返回个数
        // 含两种情况：一、包含root的路径；二、不包含root的路径
        if (root == null) return 0;

        int res = 0;
        // 路径中包含root
        res += findPath(root, sum);

        // 路径中不包含root，所以从其子节点开始递归
        res += pathSum(root.right, sum);
        res += pathSum(root.left, sum);
        return res;
    }

    // 以node为根节点的二叉树，寻找包含node的和为sum的路径，返回个数
    // 这就一种情况：必须包含node（node不一定是整个树的根节点，可能就是当前节点为其实）

    int findPath(TreeNode node, int num) {
        // 递归终止条件
        if (node == null) return 0;

        int res = 0;

        // 当前node的路径正好就是sum
        if (node.val == num) res += 1;
        // 含负数，所以可能向下有些节点的值相加相互抵消还会等于sum
        res += findPath(node.right, num - node.val);
        res += findPath(node.left, num - node.val);

        return res;
    }
}

/*
本题感悟：
一、解题思路：
  本题要找的路径分多种情况：
    一是一条满足和为sum的路径，其中包含root根节点；
    另一种情况是，根节点不包含在内，也能满足情况。
二、两个方法：
    pathSum这一个方法，递归调用时无法满足上面两种情况的，
    所以要定义一个新的方法（findPath）来解决其中一种情况。
    所以findPath解决的是包含根节点地寻找和为sum的路径；

三、两处递归：
    findPath递归：就是不断利用这个“已经写好的”方法来不断寻找和为num，包含传入的node节点的路径；
    pathSum 递归：利用它找不包含传入的root节点的和为sum的路径。在这个方法体中，包含的情况直接调用findPath方法

 */