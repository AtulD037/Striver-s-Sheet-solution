package ProblemSet_05.TheoryOfLinkedList;

// This is custom linked list and some methods
public class CustomLL {
    private Node head; // Node for the head of linked list
    private Node tail; // Node for the tail of linked list
    private int size;

    public CustomLL(){
        this.size=0;
    }
    // Node class of linked list for address reference
    private class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // Insertion
    public void insertFirst(int val){
        Node node = new Node(val);
        if(tail==null){
            tail=head;
        }
        node.next = head;
        head=node;
        size++;
    }
    public void insert(int val,int index){
        if (index==0){
            insertFirst(val);
            return ;
        }
        if (index==size){
            insertLast(val);
            return ;
        }
        Node temp = head;
        // index is 3 go till two
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }

        Node node = new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public void insertLast(int val){
        if (tail==null){
            insertFirst(val);
            return;
        }Node node = new Node(val);
       tail.next=node;
        tail=node;
        size++;
    }
    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    // Fetching a node by using its index
    public Node get(int index){
        // This will return reference pointer to that node
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    // Deletion

    // First position delete
    public int deleteFirst(){
        Node first = head;
        head = head.next;
        if (head==null){
            tail=null;
        }
        size--;
        return first.val;
    }
    public int deleteLast(){
        if (size<=1){
            return deleteFirst();
        }
        Node secondLastNode = get(size-2);
        int val = tail.val;
        tail=secondLastNode;
        tail.next=null;
        size--;
        return val;
    }
    public int delete(int index){
        if (index==0){
            deleteFirst();
        }
        if (index==size-1){
            deleteLast();
        }
        Node prev = get(index-1);
        int value = prev.next.val;
        prev.next=prev.next.next;
        return value;

    }

}
