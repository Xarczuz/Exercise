package LeetCode;

public class ConvertBinaryNumberinaLinkedListtoInteger1290 {

    public int getDecimalValue(ListNode head) {
        int nr = 0;
        while (head != null) {
            nr <<= 1;
            nr += head.val;
            head = head.next;
        }
        return nr;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }
}
