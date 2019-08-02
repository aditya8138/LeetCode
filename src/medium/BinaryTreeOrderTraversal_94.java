package medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOrderTraversal_94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        System.out.println(root.val);

        if (root.left != null) {

            inorderTraversal(root.left);
        }
        res.add(root.val);
        if (root.right != null) {

            inorderTraversal(root.right);
        }

        return res;
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
