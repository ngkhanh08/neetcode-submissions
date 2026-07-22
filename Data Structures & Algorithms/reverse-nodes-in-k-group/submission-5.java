/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;

        for (int i = 0; i < k; i++) {
            if (cur == null)
                return head;
            cur = cur.next;
        }

        // reverse first k node in the list
        ListNode newhead = reverseNode(head, k);

        // recuresive
        head.next = reverseKGroup(cur, k);

        return newhead;
    }

    public ListNode reverseNode (ListNode head, int k){
        ListNode newHead = null;

        while (head != null && k > 0){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            k--;
        }
        return newHead;

    }
}
