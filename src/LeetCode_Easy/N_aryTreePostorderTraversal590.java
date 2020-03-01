package LeetCode_Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal590 {

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<Integer> rArr = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            rArr.addFirst(root.val);
            for (Node n : root.children) {
                stack.push(n);
            }
        }
        return rArr;
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