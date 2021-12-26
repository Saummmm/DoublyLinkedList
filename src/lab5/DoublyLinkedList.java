/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author saum
 */
public class DoublyLinkedList<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        //Methods to obtain both the data and the pointer within the node
        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        //Method to set the pointer
        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head; //Automatically assigned to null on start.
    private Node<E> tail; 

    int size = 0;

    public DoublyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Returns the head or tail
    public E last() {
        if (size == 0) {
            return null;
        } else {
            return tail.getElement();
        }
    }

    public E first() {
        if (size == 0) {
            return null;
        } else {
            return head.getElement();
        }
    }

    public Node<E> middleNode(Node<E> start, Node<E> end) {
        Node<E> mid = start;
        //if empty, the middle is null
        if (isEmpty()) {
            return null;
        }
        //loop to find middle node, uses a skipping pattern to reach middle from start node
        while (start != end) {
            start = start.getNext();
            if (start != end) {
                start = start.getNext();
                mid = mid.getNext();
            }
        }
        return mid;
    }

    public boolean search(E target, Node<E> start, Node<E> end) throws NullPointerException {
        Node<E> midNode = middleNode(start, end);
        // binary search through recursion
        if (start == tail.getPrevious()) { //base case
            return false;
        } else if (midNode.getElement() == target) { //base case
            return true;
        } else if ((int) target < (int) midNode.getElement()) {
            return search(target, start, midNode); //recursive call
        } else {
            return search(target, midNode, end); //recursive call
        }
    }

    public void find(E target) throws NullPointerException {
        boolean ans = search(target, head, tail);
        if (ans == true) {
            System.out.println("The number: " + target + " is part of the list");
        } else {
            throw new NullPointerException("The number " + target + " was not found");
        }
    }

    //Creating a new head or tail
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, head, null);

        if (size == 0) {
            tail = newNode;
        } else {
            head.setPrevious(newNode);
        }
        head = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null, tail);

        if (size == 0) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        E firstElement = head.getElement();

        head = head.getNext();
        head.previous = null;
        size--;
        if (size == 0) {
            tail = null;
            head = null;
        }
        return firstElement;
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }
        E firstElement = tail.getElement();

        tail = tail.getPrevious();
        tail.next = null;
        size--;
        if (size == 0) {
            tail = null;
            head = null;
        }
        return firstElement;
    }

    public void printAllFromHead() {
        Node<E> currentNode = head;

        while (currentNode != null) {

            System.out.print(currentNode.getElement());

            currentNode = currentNode.getNext();
            System.out.println(" ");
        }
        System.out.println("\n");
    }

    public void printAllFromTail() {
        Node<E> currentNode = tail;

        while (currentNode != null) {

            System.out.print(currentNode.getElement());

            currentNode = currentNode.getPrevious();
            System.out.println(" ");
        }
        System.out.println("\n");
    }

}
