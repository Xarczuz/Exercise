package LeetCode_Easy;

import java.util.ArrayList;

public class LeetCode_234_PalindromeLinkedList {
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

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = arr.size() - 1; i < j; i++, j--) {
            if (!arr.get(i).equals(arr.get(j))) {
                return false;
            }
        }
        return true;
    }

}
