package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<VisitedNode> visitedNodes = new HashSet<>();
        ListNode node = head;
        visitedNodes.add(new VisitedNode(node));
        node = node.next;
        while (node != null) {
            if (node.next == null) {
                return false;
            }
            node = node.next;
            VisitedNode visitedNode = new VisitedNode(node);
            if (visitedNodes.contains(visitedNode)) {
                return true;
            } else {
                visitedNodes.add(visitedNode);
            }
        }
        return false;
    }

    private static class VisitedNode {
        boolean visited;
        ListNode listNode;

        public VisitedNode(ListNode listNode) {
            this.listNode = listNode;
            this.visited = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VisitedNode that = (VisitedNode) o;

            if (visited != that.visited) return false;
            return listNode != null ? listNode.equals(that.listNode) : that.listNode == null;
        }

        @Override
        public int hashCode() {
            int result = (visited ? 1 : 0);
            result = 31 * result + (listNode != null ? listNode.hashCode() : 0);
            return result;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
