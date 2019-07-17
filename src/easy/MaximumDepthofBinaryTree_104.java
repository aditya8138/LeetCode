package easy;

public class MaximumDepthofBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return depth;
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
