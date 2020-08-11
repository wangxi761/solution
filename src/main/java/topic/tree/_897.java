package topic.tree;


public class _897 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
