/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // code here
        
        Node p = head;
        Node q = head;
        
        while(p != null){
            if(p.data != q.data){
                q.next = p;
                p.prev = q;
                q = p;
            }
            
            p = p.next;
            q.next = null;
        }
        return head;
    }
}