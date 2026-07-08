class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // check if we have at least k nodes
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) return head; // not enough nodes
            curr = curr.next;
        }

        // reverse first k nodes
        ListNode newHead = reverseList(head, k);

        // head is now the tail of the reversed segment
        head.next = reverseKGroup(curr, k);

        return newHead;
    }

    private ListNode reverseList(ListNode head, int k) {
        ListNode newHead = null;
        while (head != null && k > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            k--;
        }
        return newHead;
    }
}
