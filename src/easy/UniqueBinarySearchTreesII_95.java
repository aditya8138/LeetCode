package easy;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate_trees(1, n);
    }

    public List<TreeNode> generate_trees(int start, int end) {
        List<TreeNode> resList = new LinkedList<>();
        if (start > end) {
            resList.add(null);
            return resList;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generate_trees(start, i - 1);
            List<TreeNode> rightTrees = generate_trees(i + 1, end);

            // connect left and right subtree to the root

            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    resList.add(current);
                }
            }
        }
        return resList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
