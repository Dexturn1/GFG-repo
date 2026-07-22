/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        
        Node temp0 = dummy0;
        Node temp1= dummy1;
        Node temp2 = dummy2;
        
        
        while(head!= null){
            
            if(head.data == 0){
                temp0.next = head;
                temp0 = temp0.next;
            } 
            else if(head.data == 1){
                temp1.next = head;
                temp1 = temp1.next;
            }
            else{
                temp2.next = head;
                temp2 = temp2.next;
            }
                
            head = head.next;
        }
        
        temp2.next = null;
        temp0.next = dummy1.next != null ? dummy1.next : dummy2.next;
        temp1.next = dummy2.next;
        
        return dummy0.next;
        
    }
}