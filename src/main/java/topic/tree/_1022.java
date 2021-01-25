package topic.tree;

import struct.TreeNode;

public class _1022 {


    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        rec(root, 0);
        return sum;
    }

    public void rec(TreeNode root, int val) {
        int now = root.val + val * 2;
        if (root.left != null) {
            rec(root.left, now);
        }
        if (root.right != null) {
            rec(root.right, now);
        }
        if (root.left == null && root.right == null) {
            sum += now;
        }
    }
}
