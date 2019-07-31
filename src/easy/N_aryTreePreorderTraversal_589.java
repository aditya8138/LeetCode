package easy;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorderTraversal_589 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
