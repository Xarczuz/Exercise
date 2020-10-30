package LeetCode_Easy;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_225_ImplementStackusingQueues {
    class MyStack {
        //one Queue solution
        private Queue<Integer> q = new LinkedList<>();

        // Push element x onto stack.
        public void push(int x) {
            q.add(x);
            for (int i = 1; i < q.size(); i++) { //rotate the queue to make the tail be the head
                q.add(q.poll());
            }
        }

        // Removes the element on top of the stack.
        public int pop() {
            return q.poll();
        }

        // Get the top element.
        public int top() {
            return q.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q.isEmpty();
        }
    }

}
