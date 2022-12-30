package Day05;

public class MiddleOfLinkedList {
        private class Node{
            int value;
            Node next;
            public Node(){}
            public Node(int value) {
                this.value = value;
            }

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        // Reach middle of linked list
    public Node middleOfLinkedList(Node head){
        Node slow = head; // Take a slow pointer which have tendency to travel only 1 position,initially equals to head
        Node fast = head; // Take a fast pointer which has the tendency to travel 2 positions, initially equals to head
        while (fast!=null && fast.next!=null){ // Till fast pointer or fast reference reaches end , run the loop
            slow=slow.next; // Move slow pointer one position
            fast = fast.next.next; // Move fast pointer two position ahead in one iteration
        }
        return slow; // Return the slow pointer
        // The Conclusion is that till fast pointer reaches end - half pointer will reach only the half of linked list.
    }


    // Reverse the linked list
    public Node reverseLinkedList(Node head){
            // Take two pointer Nodes
            Node previous =null; // Take a previous node which is initially pointing to null
            Node current = head; // Take a current node which is initially equals to head;

        while(current!=null){// Take a while loop and run until it reaches end of linked-list
            Node next = current.next; // Take another note to store the original reference of the node
            current.next = previous; // Now make changes in the reference address of current node(Now it will point towards the prev node)
            previous = current; //Now move the previous pointer to current
            current = next;// And move current pointer ahead
        }
        return previous; // return the reversed head
        // The conclusion is that store the original pointer and move the pointer backwards and make generic changes
    }

    public Node mergeLinkedList(Node list1,Node list2){
            Node dummyHead = new Node(); // Take a dummy head or empty node
            Node tail = dummyHead; // Take a node tail which is initially equal to dummyHead

            while (list1!=null && list2!=null){// till one of the list reaches null
                if (list1.value<list2.value){ // If value of list1 node is less add it in the reference of new node
                    tail.next=list1; // tail now points to list1
                    list1=list1.next;// move list1 ahead 1 point
                }
                else {
                    tail.next=list2; // if list2 has value greater than tail1 add it to the tail
                    list2=list2.next;// Move list2 ahead 1 point
                }
                tail = tail.next; // Move the tail 1 point after adding node value and reference in it
            }
            if (list1!=null) tail.next = list1; // If there are some remaining elements in list one which obviously means they are greate than lis2
            if (list2!=null) tail.next = list2; // and vice-versa
        return tail;// Return after wards node

        // Conclusion is that run the loop till one of them reaches null (and add it in reference of new node - whose value is less will be added first)
     }



}
