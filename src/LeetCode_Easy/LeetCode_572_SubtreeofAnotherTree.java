package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_572_SubtreeofAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }

        Stack<TreeNode> treeNodeS = new Stack<>();
        treeNodeS.add(s);

        while (!treeNodeS.empty()) {
            TreeNode node = treeNodeS.pop();

            if (node.val == t.val) {
                if (isItASubTree(node, t)) {
                    return true;
                }
            }
            if (node.left != null) {
                treeNodeS.add(node.left);
            }
            if (node.right != null) {
                treeNodeS.add(node.right);
            }

        }


        return false;
    }

    private boolean isItASubTree(TreeNode subTree, TreeNode t) {
        Stack<TreeNode> treeNodeS = new Stack<>();
        treeNodeS.add(subTree);
        treeNodeS.add(t);

        while (!treeNodeS.empty()) {
            TreeNode node1 = treeNodeS.pop();
            TreeNode node2 = treeNodeS.pop();

            if (node1.val != node2.val) {
                return false;
            }
            if (node1.left != null && node2.left != null) {
                treeNodeS.add(node1.left);
                treeNodeS.add(node2.left);
            } else if (node1.left != null || node2.left != null) {
                return false;
            }
            if (node1.right != null && node2.right != null) {
                treeNodeS.add(node1.right);
                treeNodeS.add(node2.right);

            } else if (node1.right != null || node2.right != null) {
                return false;
            }

        }

        return true;
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null ^ t == null) {
            return false;
        }
        return check(s, t) || isSubtree2(s.left, t) || isSubtree2(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && isSubtree2(s.right, t.right);
    }
}
