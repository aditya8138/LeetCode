package easy;

public class UnivaluedBinaryTree_965 {
    public static boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (!isUnivalTree(root.left)) {
                return false;
            }
            if (root.left.val != root.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (!isUnivalTree(root.right)) {
                return false;
            }
            return root.right.val == root.val;
        }
        return true;
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
