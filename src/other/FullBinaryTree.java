package other;

import java.util.ArrayList;
import java.util.List;

public class FullBinaryTree {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (N % 2 == 0) {
            return nodeList;
        }
        if (N == 1) {
            nodeList.add(new TreeNode(0));
            return nodeList;
        }

        for (int leftNum = 1; leftNum <= N - 1; leftNum += 2) {
            List<TreeNode> leftNodeList = allPossibleFBT(leftNum);
            List<TreeNode> rightNodeList = new ArrayList<>(N - leftNum + 1);

            for (TreeNode left : leftNodeList) {
                for (TreeNode right : rightNodeList) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = left;
                    treeNode.right = right;
                    nodeList.add(treeNode);
                }
            }

        }
        return nodeList;
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


