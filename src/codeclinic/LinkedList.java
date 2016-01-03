package codeclinic;

/**
 * Created by Ebrar on 02/01/16.
 */
public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        size = 0;
        head = null;
    }

    public Node getHead(){
        return head;
    }

    public boolean isEmpty(){
        return size == 0;
    }



    private class Node{
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }

}
