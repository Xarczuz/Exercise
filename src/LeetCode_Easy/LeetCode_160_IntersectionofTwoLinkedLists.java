package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_160_IntersectionofTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> listNodes = new HashSet<>();
        while (headA != null) {
            listNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!listNodes.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
