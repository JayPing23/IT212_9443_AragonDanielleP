/**
 * Name: Aragon, Danielle John P.
 * Date: September 09, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 * Algorithm
 * 1. Create a public class LinkedListNodeAragonDanielle
 *      with private instance variables data and next,
 *      and public getter and setter methods for these variables.
 * 2. In the LinkedListNodeAragonDanielle class,
 *      create a public constructor that takes a parameter data
 *      and initializes the instance variables accordingly.
 * 3. Implement a public getter method getData()
 *      in the LinkedListNodeAragonDanielle class to return the stored data.
 * 4. Implement a public getter method getNext()
 *      in the LinkedListNodeAragonDanielle class
 *      to return the next node in the linked list.
 * 5. Implement a public setter method setNext(next)
 *      in the LinkedListNodeAragonDanielle class to set the next node.
 */
package prelim.Util;
/**
 * LinkedNode class represents a node in a linked list.
 *
 * @param <T> The type of data stored in the node.
 */
public class LinkedNode<T> {
    // Instance Variables
    private T data;             // Data stored in the node
    private LinkedNode<T> next; // Reference to the next node in the list
    private LinkedNode<T> prev; // Reference to the previous node in the list

    /**
     * Constructor to create a LinkedNode with specified data.
     *
     * @param data The data to be stored in the node.
     */
    public LinkedNode(T data) {
        this.data = data;
        this.next = null; // Initialize next reference to null
        this.prev = null; // Initialize prev reference to null
    }

    /**
     * Constructor to create a LinkedNode with specified data and a reference to the next node.
     *
     * @param data The data to be stored in the node.
     * @param next The reference to the next node in the list.
     */
    public LinkedNode(T data, LinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Getter method to retrieve the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Setter method to set the data stored in the node.
     *
     * @param data The data to be set in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter method to retrieve the reference to the next node in the list.
     *
     * @return The reference to the next node in the list.
     */
    public LinkedNode<T> getNext() {
        return next;
    }

    /**
     * Setter method to set the reference to the next node in the list.
     *
     * @param next The reference to the next node in the list.
     */
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    /**
     * Getter method to retrieve the reference to the previous node in the list.
     *
     * @return The reference to the previous node in the list.
     */
    public LinkedNode<T> getPrev() {
        return prev;
    }

    /**
     * Setter method to set the reference to the previous node in the list.
     *
     * @param prev The reference to the previous node in the list.
     */
    public void setPrev(LinkedNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Overrides the toString method to provide a string representation of the node's data.
     *
     * @return A string representation of the node's data.
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
