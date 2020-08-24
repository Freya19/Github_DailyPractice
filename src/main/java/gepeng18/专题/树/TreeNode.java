package gepeng18.专题.树;

import lombok.Data;

@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {
    }
    TreeNode(int x) {
        val = x;
    }
}
