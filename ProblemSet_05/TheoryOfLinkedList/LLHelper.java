package ProblemSet_05.TheoryOfLinkedList;

public class LLHelper {
    public Node head;

    public LLHelper() {
    }

    private class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
