package topic.tree;

import java.util.ArrayList;
import java.util.List;

public class _589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        recursive(res, root);
        return res;

    }

    public void recursive(List<Integer> result, Node node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            recursive(result, child);
        }
    }
}
