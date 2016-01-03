package codeclinic;

/**
 * Created by Ebrar on 02/01/16.
 */
public class Stacks {

    private int size;
    private Node first;

    public Stacks() {
        size = 0;
        first = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(int item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow...");
        }
        int item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow...");
        }
        return first.item;
    }

    public static boolean isSameContent(Stacks stack1, Stacks stack2){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        else if(stack1.isEmpty() && !stack2.isEmpty()){
            return false;
        }
        else if(!stack1.isEmpty() && stack2.isEmpty()){
            return false;
        }
        else if(stack1.pop() != stack2.pop()){
            return false;
        }
        else{
            return isSameContent(stack1,stack2);
        }
    }


    private class Node{
        private int item;
        private Node next;
    }
}
