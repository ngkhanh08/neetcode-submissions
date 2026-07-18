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

        // chekc edge case
        if ( head == null ) return null;

        // Using Map original node -> copy node;
        HashMap<Node, Node> map = new HashMap<>();

        // Create copy nodes, put them in map
        Node cur = head;
        while ( cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 2. Assigne next and random using the map
        cur = head;
        while ( cur != null){
            Node copy = map.get(cur);
            copy.next = (cur.next != null) ? map.get(cur.next) : null;
            copy.random = (cur.random != null) ? map.get(cur.random) : null;
            cur = cur.next;
        }        
        return map.get(head);
    }
}
