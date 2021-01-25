package topic.tree;

import struct.TreeNode;

public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node=root.right;
        root.right=root.left;
        root.left = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
