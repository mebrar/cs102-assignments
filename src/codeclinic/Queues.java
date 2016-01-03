package codeclinic;

/**
 * Created by Ebrar on 02/01/16.
 */
public class Queues {

    private int size;
    private Node first;
    private Node last;

    public Queues() {
        size = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue Underflow...");
        }
        return first.item;
    }

    public void enqueue(int item){
        Node oldLast = last;

        last = new Node(item, null);

        if(isEmpty()){
            first = last;
        }
        else{
            oldLast.next = last;
        }
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow...");
        }
        int item = first.item;
        first = first.next;
        size--;
        return item;
    }

    private class Node{
        private int item;
        private Node next;

        public Node() {
        }

        public Node(int item) {
            this.item = item;
            next = null;
        }

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
