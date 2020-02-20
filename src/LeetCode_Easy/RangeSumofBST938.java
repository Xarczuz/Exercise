package LeetCode_Easy;

import java.util.HashSet;
import java.util.LinkedList;

public class RangeSumofBST938 {
    public static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root == null) {
            return 0;
        } else {
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);
        }
        int value = root.val;
        if (L <= value && value <= R) {
            return root.val + sum;
        }
        return sum;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int rangeSumBST2(TreeNode root, int L, int R) {
        int sum = 0;
        int interval = L - R;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.pop();
            if (L <= treeNode.val && treeNode.val <= R) {
                hashSet.add(treeNode.val);
                sum += treeNode.val;
                if (hashSet.size() == (interval)) {
                    break;
                }
            }
            if (treeNode.right != null) {
                treeNodes.push(treeNode.right);
            }
            if (treeNode.left != null) {
                treeNodes.push(treeNode.left);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode((10));
        treeNode0.left = new TreeNode((5));
        treeNode0.right = new TreeNode((15));
        treeNode0.left.left = new TreeNode((3));
        treeNode0.left.right = new TreeNode((7));
        treeNode0.left.left.right = new TreeNode((18));
        System.out.println(rangeSumBST2(treeNode0, 7, 15));
    }
}