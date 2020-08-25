package gepeng18.专题.树;
import java.util.LinkedList;
import java.util.Queue;

public class 构造完全二叉树 {
    class BinaryNode {
        int val;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int val) {
            this.val = val;
        }
    }//Binary
    private BinaryNode root;//根节点,这个属性很重要

    public void printTreeLineByLine(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();//把待打印的结点放在队列中
        BinaryNode curNode;
        queue.offer(root);
        int curNum = 1;//当前行未打印的节点数
        int next = 0;//下一行待打印的节点数
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            System.out.print(curNode.val + " ");
            curNum--;
            if (curNode.left != null) {
                queue.offer(curNode.left);
                next++;
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                next++;
            }
            if (curNum == 0) {
                curNum = next;
                next = 0;
                System.out.println();//换行
            }
        }//while
    }//printTreeLineByLine

    public void buildCompleteTree(int[] nodes) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        int next = 0;//该结点的已构造的子结点个数
        root = new BinaryNode(nodes[0]);//用到了root属性
        BinaryNode curNode = root;//当前正在构造的结点
        int count = 1;//表示当前已构造到的nodes[]的元素下标
        while (count < nodes.length) {//这个条件不是while(!queue.isEmpty())
            if (next == 2) {
                curNode = queue.poll();
                next = 0;
            }
            if (curNode.left == null && count < nodes.length) {
                curNode.left = new BinaryNode(nodes[count++]);
                queue.offer(curNode.left);
                next++;
            }
            if (curNode.right == null && count < nodes.length) {
                curNode.right = new BinaryNode(nodes[count++]);
                queue.offer(curNode.right);
                next++;
            }
        }//while
    }//buildCompleteTree

    public static void main(String[] args) {
        构造完全二叉树 bst = new 构造完全二叉树();
//        int[] arr = {2, 4, 5, 1, 3,6,7,8,9,10,12,13,14,15,16,17,18};
        int[] arr = {2, 4, 5, 1, 3, 6, 7, 8};
        bst.buildCompleteTree(arr);
        bst.printTreeLineByLine(bst.root);//用到了root属性
    }//main
}
