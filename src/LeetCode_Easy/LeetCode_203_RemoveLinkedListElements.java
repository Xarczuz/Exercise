package LeetCode_Easy;

public class LeetCode_203_RemoveLinkedListElements {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        //0-> [1,2,6,3,4,5,6,6,9,6,9,3,6,0] val = 1
        //0-> [2,6,3,4,5, , ,9,6,9,3,6,0] val = 6

        ListNode start = new ListNode();
        ListNode theHead = start;
        start.next = head;
        while (start.next != null) {
            if (start.next.val == val) {
                start.next = start.next.next;
            } else {
                start = start.next;
            }
        }
        return theHead.next;
    }
}
