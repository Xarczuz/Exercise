package LeetCode_Easy;

import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal590 {

    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            for (Node n : root.children) {

            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
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
};