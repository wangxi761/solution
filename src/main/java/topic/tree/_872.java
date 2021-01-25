package topic.tree;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _872 {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        recursive(root1, left);
        recursive(root2, right);
        return left.equals(right);
    }


    public void recursive(TreeNode root, List<Integer> list) {
        if(root==null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        recursive(root.left, list);
        recursive(root.right, list);
    }

}
