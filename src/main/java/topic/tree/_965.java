package topic.tree;

import struct.TreeNode;

public class _965 {



    public boolean isUnivalTree(TreeNode root) {
        return rec(root, root.val);
    }

    public boolean rec(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && rec(root.left, val) && rec(root.right, val);
    }
}
