package LeetCode_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_589_N_aryTreePreorderTraversal {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> rArr = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            rArr.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.push(root.children.get(i));
            }
        }
        return rArr;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
