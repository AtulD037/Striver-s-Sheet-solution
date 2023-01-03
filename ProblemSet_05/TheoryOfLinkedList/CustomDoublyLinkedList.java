package ProblemSet_05.TheoryOfLinkedList;

public class CustomDoublyLinkedList {
    private Node head; // Node for the head of linked list
    private int size;

    public CustomDoublyLinkedList() {
        this.size = 0;
    }

    // Node class of linked list for address reference
    private class Node {
        private int val;
        private Node next;
        private Node prev;
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val); // Create a node
        node.next=head; // node's next pointer now points to the head node -> head
        node.prev = null;// Node's prev pointer now pointer to null null <- node
        if (head!=null){ // If head is not equal to null then only perform this operation
            head.prev = node; //  node <- head
        }
        head = node; // Now make the node as new head
    }
    public void display(){
        Node temp = head; // Take a temporary node
        while (temp!=null){ // Run the loop until last (till temp node becomes null)
            System.out.print(temp.val+" <-> "); // print value of current node
            temp=temp.next;// Move node one point ahead
        }
        System.out.println("End"); // Print end at the last to confirm that we have finished our iteration
    }
    public void reverseDisplay(){
        Node last = null;
        while (last!=null){
            System.out.println(last.val+" -> ");
            last=last.prev;
        }
        System.out.println("End");
    }
}