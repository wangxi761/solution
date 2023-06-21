package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.TreeNode;

public class SumofRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return rec(root, 0);
    }

    public int rec(TreeNode root, int sum) {
        sum = sum * 2 + root.val;
        return root.left == null ? (root.right == null ? sum : rec(root.right, sum)) : (root.right == null ? rec(root.left, sum) : rec(root.left, sum) + rec(root.right, sum));
    }

    @Test
    public void test() {
//        Assertions.assertEquals(2,sumRootToLeaf());
    }
}


