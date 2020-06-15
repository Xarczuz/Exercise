package LeetCode_Easy;

public class LeetCode_83_RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(4);
        ListNode head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        head = new LeetCode_83_RemoveDuplicatesfromSortedList().deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode temp;
        int prevVal = head.val;
        while (true) {
            temp = a;
            a = a.next;
            if (a == null) {
                break;
            }
            if (a.val == prevVal) {
                while (true) {
                    if (a.val == prevVal) {
                        a = a.next;
                        if (a == null) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (a == null) {
                    temp.next = a;
                    break;
                }
            }
            prevVal = a.val;
            temp.next = a;

        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
