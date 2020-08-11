package topic.tree;

import struct.TreeNode;

public class _617 {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        } else if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null && t2 != null) {
            return t2;
        } else {
            return t1;
        }
        return t1;
    }

}
