package ProblemSet_05;

// 1. Find the middle of linked list
// 2. Reverse the linked list if head is given
// 3. Merge two LinkedList
// 4. Remove Nth node from the linked list
// 5. Add two Numbers as Linked List
// 6. Delete Node in a Linked List
public class LinkedListSet01 {
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
        //1. Reach middle of linked list
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
/*----------------------------------**********************---------------------------------------*/

    // 2.Reverse the linked list
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
    /*----------------------------------**********************---------------------------------------*/
        //3. Merge two linked list
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
    /*----------------------------------**********************---------------------------------------*/

    // 4. Remove Nth Node from linked list
    // Given the head of a linked list, remove the nth node from the end of the list and return its head
    public Node removeNthNode(Node head,int k){
        Node temp = new Node();
        temp.next = head;

        Node slow = temp;// Take a slow pointer
        Node fast = temp;// Take a fast pointer

        for (int i = 0; i < k; i++) {
            fast=fast.next;// Move fast pointer k node ahead
        }
        while (fast!=null){// If fast pointer is not equals to null
            slow=slow.next; // Slow - will be moved 1 point ahead
            fast = fast.next;// Fast - will also move one point ahead
        }// After that fast will reach end and slow will reach k distance form end
        slow.next = slow.next.next;// make the slow pointer to point one position ahead of current next position
        return temp.next;// Return temp.next
    }
    /*----------------------------------**********************---------------------------------------*/
    // 5. You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit.
    // Add the two numbers and return the sum as a linked list.
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    public Node addTwoNumbersAsLinkedList(Node l1,Node l2){
        Node dummyHead = new Node(0); // Take a dummy node with initial value of zero
        Node curr = dummyHead; // Take the current node = dummy-node
        Node p = l1; // p variable for linked list node l1
        Node q = l2;//  q variable for linked list node l2
        int carry = 0; // Initialize carry as zero
        while (p!=null || q!=null){ // Until both of them reaches null
            int x = (p!=null) ? p.value : 0; // Take integer x as p.value if exist so, otherwise consider it to be 0
            int y = (q!=null) ? q.value : 0;// Take integer y as q.value if exist so or else consider them to zero
            int digit = x+y+carry; // Take the digit as sum of x,y and carry

            carry = digit/10; // carry can be generated by dividing the digit by 10
                curr.next = new Node(digit%10);// Take current's next as new node with modulus value of digit
                curr=curr.next; // move the current pointer ahead

                if (p!=null) p = p.next; // If we are left with only p values move ahead
                if (q!=null) q = q.next;// If we are left only with q values move ahead
            }
            if (carry>0){ // If carry is greater than 0 or after all of this we are left with the carry then create a new node assign value of carry in it.
            curr.next = new Node(carry);
        }
            return dummyHead.next; // Return the dummyhead.next because dummy head is initially equal to zero
    }
    /*----------------------------------**********************---------------------------------------*/

    /*5.There is a singly-linked list head and we want to delete a node node in it.
    You are given the node to be deleted node. You will not be given access to the first node of head.
    All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
    Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
    The value of the given node should not exist in the linked list.
    The number of nodes in the linked list should decrease by one.
    All the values before node should be in the same order.
    All the values after node should be in the same order.
    Custom testing:
    For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
    We will build the linked list and pass the node to your function.
    The output will be the entire list after calling your function*/

    public void deleteAGivenNode(Node node){
        node.value = node.next.value; // Store the value of next node in this node
        node.next = node.next.next; // Now skip the next node
    }
}
