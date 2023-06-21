package daily;

import struct.TreeNode;

public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        } else if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        } else {
            insertIntoBST(val > root.val ? root.right : root.left, val);
        }
        return root;
    }


}
