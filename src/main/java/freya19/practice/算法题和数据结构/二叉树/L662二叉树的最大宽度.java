package freya19.practice.算法题和数据结构.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L662二叉树的最大宽度 {
    /**
     * 非递归解法 GP18
     */
    public int widthOfBinaryTree1(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }


    /** huahua 题解*/

    /** 记录 每层树 最左 节点 的编号 */
    private List<Integer> ids;

    /** 入口函数 */
    public int widthOfBinaryTree(TreeNode root) {
        ids = new ArrayList<>();
        return calculateWidth(root, 0, 0);
    }

    /**
     * 核心函数  递归得到宽度
     * @param root  根节点（当前节点）
     * @param deep  当前的所在的深度
     * @param id    当前节点的编号
     * @return 宽度
     */
    private int calculateWidth(TreeNode root, int deep, int id) {
        if (root == null) {
            return 0;
        }
        if(ids.size()==deep){
            // 将树每层最左边的节点编号保存到list中
            ids.add(id);
        }

        // 是当前这个节点的宽度 还是其左右子节点（递归）得到的宽度
        return Math.max(id-ids.get(deep)+1,
                Math.max(calculateWidth(root.left,deep+1,2*(id-ids.get(deep))),
                        calculateWidth(root.right,deep+1,2*(id-ids.get(deep))+1)));
    }
}
