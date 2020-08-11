package topic.tree;

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node.val <= R&&node.right!=null) {
                deque.push(node.right);
            }
            if (node.val >= L&&node.left!=null) {
                deque.push(node.left);
            }
            if (node.val <= R && node.val >= L) {
                sum+= node.val;
            }

        }
        return sum;
    }
}
