package LeetCode_Easy;

public class MergeTwoSortedLists21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;

        if (l1.val <= l2.val) {
            head = new ListNode(l1.val);
        } else {
            head = new ListNode(l2.val);
        }
        merge(head, l1, l2);

        return head;
    }

    private void merge(ListNode next, ListNode l1, ListNode l2) {

        while (l1 != null) {
            if (l1.val <= l2.val) {
                next.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                next.next = new ListNode(l2.val);
                l2 = l2.next;
            }
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode res;
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l2 == null && l1 != null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return null;
        }
        if (l1.val <= l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        ListNode head = res;
        while (true) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    res.next = l1;
                    l1 = l1.next;
                } else {
                    res.next = l2;
                    l2 = l2.next;
                }
                res = res.next;
            }
            if (l1 != null && l2 == null) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
            if (l1 == null && l2 != null) {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
            if (l1 == null && l2 == null) {
                return head;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node2sub = new ListNode(2);
        node2.next = node2sub;
        node2sub.next = new ListNode(3);

        ListNode nodeRes = new MergeTwoSortedLists21().mergeTwoLists2(node1, node2);

        while (nodeRes != null) {
            System.out.println(nodeRes.val);
            nodeRes = nodeRes.next;
        }
    }
}
