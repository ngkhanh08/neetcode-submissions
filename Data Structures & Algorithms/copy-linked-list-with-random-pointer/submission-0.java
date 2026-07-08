/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // map original node → copied node
        HashMap<Node, Node> map = new HashMap<>();

        // 1. Create copy nodes (only val), put them in map
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 2. Assign next and random using the map
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = (curr.next != null) ? map.get(curr.next) : null;
            copy.random = (curr.random != null) ? map.get(curr.random) : null;
            curr = curr.next;
        }

        // 3. Return head of copied list
        return map.get(head);
    }
}
