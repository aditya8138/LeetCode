package easy;

public class InvertBinartTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private TreeNode swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

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
