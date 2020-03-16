package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_876_MiddleoftheLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        int count = 1;
        while (head != null) {
            hashMap.put(count, head);
            head = head.next;
            count++;
        }
        count++;
        return hashMap.get(count / 2);
    }

    public static void main(String[] args) {
        LeetCode_876_MiddleoftheLinkedList l = new LeetCode_876_MiddleoftheLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(l.middleNode(l1).val);
    }
}
