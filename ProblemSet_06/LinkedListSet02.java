package ProblemSet_06;
// 1.Find intersection point of Y LinkedList
// 2. Detect a cycle in Linked List
// 3.Reverse a LinkedList in groups of size k.
// 4. Check if a LinkedList is palindrome or not.
// 5. Find the starting point of the Loop of LinkedList
// 6. Flattening of a LinkedList
// 7 . Rotate a LinkedList

public class LinkedListSet02 {
    private class Node{
        int value;
        Node next;
        public Node(){}
        public Node(int value) {
            this.value = value;
        }

        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // 1 .
    // Given the heads of two singly linked-lists headA and headB,
    // return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
    public Node getIntersectionNode (Node headA, Node headB){
        // boundary check
        if (headA == null || headB == null) return null;

        Node a = headA; // Take a pointer to traverse node a
        Node b = headB;// Take a pointer to traverse node b

        while (a!=b){ // Until they both become equal run the loop and if they have different length eventually loop will stop working
            a = (a==null) ? headB: a.next; // Move a pointer ahead till it reaches null o.w. move it to other list.
            b = (b==null) ? headA :b.next;// Move b pointer ahead till it reaches null o.w move it to other list.
        }
        // if they do not meet ecentually at some point they will reach null and then so Nodes become equal and we get
        // null result
        return a; // If the meet return
    }


    // 2. Given a linked list detect a cycle in it
    public boolean cycleDetection(Node head){
        Node slow = head; // Take a slow pointer which will only move 1 nodes.
        Node fast = head;// Take a fast pointer which will only move 2 nodes.

        while (fast!=null && fast.next!=null){// run loop till fast reaches end
            slow=slow.next;// slow pointer is moved 1 position ahead
            fast=fast.next.next;// Fast pointer is moved 2 position ahead
            if (slow==fast){// If there is loop
                return true;
            }
        }
        return false;
    }
    // Find length of cycle in linked list
    public int findLengthOfLoop(Node head){
        Node slow = head;
        Node fast = head;
        int count =0;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                // Means they met
                Node temp =slow;
                do {
                    temp=temp.next;
                    count++;
                }while (temp!=fast);
            }
        }
        return count;
    }


    // 4. Check if list is palindrome or not
    public boolean palindromeCheck(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        if (fast!=null){
            slow=slow.next;
        }
        while (slow!=null){
            if (slow.value!= fast.value){
                return false;
            }
            fast=fast.next;
            slow = slow.next;
        }
        return true;
    }
    public Node reverse(Node head){
        Node prev = null;
        while (head!=null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head=next;
        }
        return prev;
    }

    //5. Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    // following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
    // is connected to (0-indexed).
    // It is -1 if there is no cycle. Note that pos is not passed as a parameter.

    public Node startingofCycle(Node head){
        // Pointers initialized as head of linked list
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){// Running the loop until
            fast=fast.next.next;// Moving slow by one
            slow=slow.next;// Moving fast by 2

            if (fast==slow){ // If they meet
                slow = head; // Reset slow to head
                while (slow!=fast){ // Move slow by one
                    slow=slow.next; // Move fast by one
                    fast=fast.next;
                }
                return slow;// return slow or fast, it means the same they will return starting of linked list
            }
        }
        return null;// If there is no cycle it will return null
    }


}
