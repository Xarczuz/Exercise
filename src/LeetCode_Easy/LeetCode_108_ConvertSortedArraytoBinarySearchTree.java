package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[(nums.length - 1) / 2]);
        Stack<Object> treeNodes = new Stack<>();
        treeNodes.push(nums.length - 1);
        treeNodes.push(0);
        treeNodes.push(head);
        while (!treeNodes.isEmpty()) {
            TreeNode node = (TreeNode) treeNodes.pop();
            int left = (int) treeNodes.pop();
            int right = (int) treeNodes.pop();
            int mid = left + (right - left) / 2;
            if (mid - 1 >= left) {
                node.left = new TreeNode(nums[left + ((mid - 1 - left) / 2)]);
                treeNodes.push(mid - 1);
                treeNodes.push(left);
                treeNodes.push(node.left);
            }
            if (mid + 1 <= right) {
                node.right = new TreeNode(nums[mid + 1 + ((right - mid - 1) / 2)]);
                treeNodes.push(right);
                treeNodes.push(mid + 1);
                treeNodes.push(node.right);
            }

        }
        return head;
    }

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
}
