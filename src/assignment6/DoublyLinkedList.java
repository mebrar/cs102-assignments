/**
 * Created by Muhammed Ebrar Erdem on 08/12/15.
 */
package assignment6;

import java.util.*;

public class DoublyLinkedList<E extends Comparable<E>> {

    private DoublyNode firstNode;
    private DoublyNode lastNode;
    private int size;

    /**
     * default constructor that only declares the size of the linked list
     */

    public DoublyLinkedList() {
        size = 0;
    }

    /**
     * private constructor for implementing clone method
     */

    private DoublyLinkedList(DoublyNode firstNode, DoublyNode lastNode, int size) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
        this.size = size;
    }

    /**
     * clone method for duplicating the current linked list
     * it does not copy the nodes or elements inside linked list, still holds the same references
     * @return the same doubly linked list that method is invoked on
     */

    @Override
    public DoublyLinkedList clone() {
        DoublyLinkedList<E> clonedList = new DoublyLinkedList<E>();
        for(int i = 0; i < size; i++){
            clonedList.insertElementAt(this.getElementAt(i), i);
        }
        return clonedList;
    }

    /**
     *
     * @param index
     * @return
     */

    public E getElementAt(int index) {
        DoublyNode currentNode;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Improper index value: " + index);
        }
        else if(index == 0){
            return getFirstElement();
        }
        else if(index == size-1){
            return getLastElement();
        }
        else {
            currentNode = firstNode;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                currentNode = currentNode.head;
            }
            return currentNode.element;
        }
    }

    /**
     *
     * @param index
     * @return
     */

    private DoublyNode getNodeAt(int index){
        DoublyNode currentNode;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Improper index value: " + index);
        }
        else if(index == 0){
            currentNode = firstNode;
        }
        else if(index == size-1){
            currentNode = lastNode;
        }
        else{
            currentNode = firstNode;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                currentNode = currentNode.head;
            }
        }
        return currentNode;
    }

    /**
     *
     * @return the first element in the linked list
     */

    public E getFirstElement() {
        if (firstNode.element == null){
            throw new NoSuchElementException("No first element in the current Linked List!");
        }
        else{
            return firstNode.element;
        }
    }

    /**
     *
     * @return the last element in the linked list
     */

    public E getLastElement() {
        if(lastNode.element == null){
            throw new NoSuchElementException("No last element in the current Linked List!");
        }
        else{
            return lastNode.element;
        }
    }

    /**
     * inserts the element to the linked list at the given index position
     * @param element to be inserted
     * @param index position of the element to be inserted
     */

    public void insertElementAt(E element, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Improper index value: " + index);
        }
        else if(isEmpty()){
            firstNode = new DoublyNode(element);
            lastNode = firstNode;
        }
        else if(!isEmpty() && index == 0){
            firstNode = new DoublyNode(element, firstNode, null);
            firstNode.head.tail = firstNode;
        }
        else if(lastNode == firstNode){
            firstNode.head = new DoublyNode(element, null, firstNode);
            lastNode = firstNode.head;
        }
        else if(index == size-1){
            DoublyNode newNode = new DoublyNode(element, lastNode, lastNode.tail);
            lastNode.tail.head = newNode;
            lastNode.tail = newNode;
        }
        else if(index == size){
            lastNode.head = new DoublyNode(element, null, lastNode);
            lastNode = lastNode.head;
        }
        else{
            DoublyNode oldNode = getNodeAt(index-1);
            DoublyNode newNode = new DoublyNode(element, oldNode.head, oldNode);
            oldNode.head = newNode;
            newNode.head.tail = newNode;
        }
        size++;
    }

    /**
     *
     * @param element
     */

    public void insertSorted(E element) {
        if(isEmpty()){
            insertElementAt(element,0);
        }
        else if(size == 1){
            if(element.compareTo(firstNode.element) > 0){
                insertElementAt(element,1);
            }
            else{
                insertElementAt(element, 0);
            }
        }
        else if(element.compareTo(firstNode.element) <= 0){
            insertElementAt(element, 0);
        }
        else if(element.compareTo(lastNode.element) >= 0 ){
            insertElementAt(element, size);
        }
        else{
            boolean isInserted = false;
            for(int i = 0; i < size-1 && !isInserted; i++){
                if(getElementAt(i+1).equals(lastNode)){
                    if(element.compareTo(lastNode.element) >=0){
                        insertElementAt(element,size);
                    }
                    else{
                        insertElementAt(element,size-1);
                    }
                    isInserted = true;
                }
                else if(element.compareTo(getElementAt(i)) >= 0 && element.compareTo(getElementAt(i+1)) <= 0){
                    insertElementAt(element, i+1);
                    isInserted = true;
                }
            }
            if(!isInserted){
                insertElementAt(element, size);
            }
        }
    }

    /**
     *
     * @param index
     */

    public void removeElementAt(int index) {
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("Improper index value: " + index);
        }
        else if(index == 0){
            removeFirstElement();
        }
        else if(index == size -1){
            removeLastElement();
        }
        else{
            DoublyNode toBeRemovedNode = getNodeAt(index);
            toBeRemovedNode.tail.head = toBeRemovedNode.head;
            toBeRemovedNode.head.tail = toBeRemovedNode.tail;
            size--;
        }
    }

    /**
     * Removes the first element from the linked list
     */

    public void removeFirstElement() {
        if(firstNode == null){
            throw new NoSuchElementException("There is no first element in the linked list!");
        }
        else if(size == 1){
            firstNode = null;
            lastNode = null;
        }
        else{
            firstNode = firstNode.head;
            firstNode.tail = null;
        }
        size--;
    }

    /**
     * Removes the last element from the linked list
     */

    public void removeLastElement() {
        if(lastNode == null){
            throw new NoSuchElementException("There is no last element in the linked list!");
        }
        else if(size == 1){
            firstNode = null;
            lastNode = null;
        }
        else{
            lastNode = lastNode.tail;
            lastNode.head = null;
        }
        size--;
    }

    /**
     * Reverses the current linked list
     */

    public void reverse() {
        DoublyNode otherTemp = firstNode;
        DoublyNode currentNode = firstNode;
        DoublyNode tempNode;

        while(currentNode != null) {
            tempNode = currentNode.head;
            currentNode.head = currentNode.tail;
            currentNode.tail = tempNode;
            if (currentNode.tail == null) {
                firstNode = currentNode;
            }
            currentNode = currentNode.tail;
        }
        lastNode = otherTemp;
        lastNode.tail = getNodeAt(size-2); // worst bugfix ever :(
        lastNode.head = null;
    }

    /**
     * isEmpty method for determining that is linked list is empty or not
     * @return true if linked list is empty, otherwise false...
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * getSize method for accessing the variable that holds the size value of the linked list
     * @return the number of elements in the current linked list
     */

    public int getSize() {
        return size;
    }

    /**
     * toString method for printing the elements in the linked list
     * @return the string representation of the every element in the linked list
     */

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < size; i++){
            result += getElementAt(i) + " ";
        }
        return result;
    }

    /**
     * private node class that holds generic element data
     * and also both head and tail reference to the other nodes
     */

    private class DoublyNode {
        E element;
        DoublyNode head;
        DoublyNode tail;

        public DoublyNode() {
        }

        public DoublyNode(E element) {
            this.element = element;
            this.head = null;
            this.tail = null;
        }

        public DoublyNode(E element, DoublyNode head, DoublyNode tail) {
            this.element = element;
            this.head = head;
            this.tail = tail;
        }
    }

    /**
     * Main method for testing the above methods...
     */
    public static void main(String[] args) {


        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.insertElementAt("Ashbury", 0);
        list.removeLastElement();
        // insertions
        list.insertElementAt("Ashbury", 0);
        list.insertElementAt("Blackroot", 1);
        list.insertElementAt("Caladon", 1);
        list.insertElementAt("Qintarra", 1);
        list.insertElementAt("Tarant", 4);
        list.insertElementAt("Tulla", 2);

        System.out.println("Normal list: " + list);
        list.reverse();
        System.out.println("Reversed list: " + list);

        DoublyLinkedList<String> clonedList = list.clone();
        System.out.println("Cloned: " + clonedList);
        clonedList.reverse();
        System.out.println("Normal: " + list);
        System.out.println("Reverse Cloned: " + clonedList);
        clonedList.removeFirstElement();
        System.out.println("First element removed cloned: " + clonedList);
        System.out.println(list.getFirstElement());
        System.out.println(list.getLastElement());

        DoublyLinkedList<String> sortedList = new DoublyLinkedList<String>();
        // sorted insertions
        sortedList.insertSorted("Caladon");
        sortedList.insertSorted("Tulla");
        sortedList.insertSorted("Blackroot");
        sortedList.insertSorted("Tarant");
        sortedList.insertSorted("Ashbury");
        sortedList.insertSorted("Qintarra");

        System.out.println("Sorted: " + sortedList);
        sortedList.reverse();
        System.out.println("Reverse sorted: " + sortedList);

    }
}
