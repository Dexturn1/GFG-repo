/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node p = head;
        while(p != null){
            if(p.data == x){
                if(p.prev == null && p.next==null){
                    return null;
                }
                // first Node 
                else if(p.prev == null){
                    head = head.next;
                    head.prev = null;
                    p = head;
                }else if(p.next == null){
                    p.prev.next = null;
                    p=p.next;
                }else{
                    p.prev.next = p.next;
                    p.next.prev = p.prev;
                    p = p.next;
                }
            }else{
                p = p.next;
            }
        }
        
        return head;
    }
}