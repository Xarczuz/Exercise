package LeetCode_Easy;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_637_AverageofLevelsinBinaryTree {

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

    public class LevelAndNode {
        TreeNode node;
        int level;

        public LevelAndNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<LevelAndNode> treeNodes = new LinkedList<>();
        treeNodes.add(new LevelAndNode(root, 0));
        LinkedList<Double> averageLevel = new LinkedList<>();
        int currentLevel = 0;
        int counter = 0;
        long currentSum = 0;
        while (!treeNodes.isEmpty()) {
            LevelAndNode lan = treeNodes.pop();
            if (lan.level == currentLevel) {
                counter++;
                currentSum += lan.node.val;
            } else {
                averageLevel.add((double) currentSum / counter);
                counter = 1;
                currentSum = lan.node.val;
                currentLevel += 1;
            }
            if (lan.node.left != null) {
                treeNodes.addLast(new LevelAndNode(lan.node.left, lan.level + 1));
            }
            if (lan.node.right != null) {
                treeNodes.addLast(new LevelAndNode(lan.node.right, lan.level + 1));
            }
        }
        averageLevel.add((double) currentSum / counter);
        return averageLevel;
    }

}
