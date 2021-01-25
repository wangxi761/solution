package topic.tree;


import struct.TreeNode;

public class _897 {


    TreeNode cur=null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        cur=head;
        rec(root);
        return head.right;
    }

    public void rec(TreeNode root) {
        if (root == null) {
            return;
        }
        rec(root.left);
        root.left=null;
        cur.right=root;
        cur = root;
        rec(root.right);

    }
}
