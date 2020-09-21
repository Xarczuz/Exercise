package LeetCode_Easy;

public class LeetCode_155_MinStack {

    private Stack current;
    private Stack currentMin;

    /**
     * initialize your data structure here.
     */
    public LeetCode_155_MinStack() {
    }

    public void push(int x) {
        Stack top = new Stack();
        top.value = x;
        top.bot = current;
        current = top;
        if (currentMin == null) {
            currentMin = current;
        } else if (current.value <= currentMin.value) {
            Stack newMin = new Stack();
            newMin.value = current.value;
            newMin.bot = currentMin;
            currentMin = newMin;
        }
    }

    public void pop() {
        if (current.value == currentMin.value) {
            currentMin = currentMin.bot;
        }
        current = current.bot;
    }

    public int top() {
        return current.value;
    }

    public int getMin() {
        return currentMin.value;
    }

    private class Stack {
        Stack bot;
        int value;
    }

    public static void main(String[] args) {
        LeetCode_155_MinStack stack = new LeetCode_155_MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}
