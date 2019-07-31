package easy;

import java.util.Stack;

public class RangeSumofBST_938 {

    public static int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val <= R && node.val >= L) {
                    ans += node.val;
                }
                if (node.val < R) {
                    stack.push(node.right);
                }
                if (node.val > L) {
                    stack.push(node.left);
                }
            }
        }
        return ans;
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
