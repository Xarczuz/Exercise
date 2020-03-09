package LeetCode_Easy;

public class LeetCode_1290_ConvertBinaryNumberinaLinkedListtoInteger {

    public int getDecimalValue(ListNode head) {
        int nr = 0;
        while (head != null) {
            nr <<= 1;
            nr += head.val;
            head = head.next;
        }
        return nr;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
    }
}
