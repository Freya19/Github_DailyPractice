package gepeng18.专题.二分查找.林沐.二分查找树;

import java.util.ArrayList;
import java.util.Arrays;

public class 逆序对 {
    static class BSTNode {
        int val;
        int count;
        BSTNode left;
        BSTNode right;

        public BSTNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            count = 0;
        }
    }

    void BST_insert(BSTNode node, BSTNode insert_node,int count_small){
        // <=
        if (insert_node.val <= node.val){
            node.count++;
            if (node.left!=null){
                BST_insert(node.left, insert_node,count_small);
            }
            else{
                node.left = insert_node;
            }
        }
        else{
            count_small += node.count + 1;
            if (node.right!=null){
                BST_insert(node.right, insert_node,count_small);
            }
            else{
                node.right = insert_node;
            }
        }
    }
    int [] countSmaller(int [] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<BSTNode> node_vec = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--){
            node_vec.add(new BSTNode(nums[i]));
        }
        count.add(0);
        for (int i = 1; i < node_vec.size(); i++){
            int count_small = 0;
            BST_insert(node_vec.get(0), node_vec.get(i), count_small);
            count.add(count_small);
        }
        for (int i = node_vec.size() - 1; i >= 0; i--){
            result.add(count.get(i));
        }

        int[] finalResult = new int[result.size()];
        for(int i = 0;i<result.size();i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int nums[] = {5, -7, 9, 1, 3, 5, -2, 1};

        逆序对 solve = new 逆序对();
        int[] result = solve.countSmaller(nums);
        System.out.println(Arrays.toString(result));
    }
}
