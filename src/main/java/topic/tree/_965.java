package topic.tree;

public class _965 {

    public class TreeNode {
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
