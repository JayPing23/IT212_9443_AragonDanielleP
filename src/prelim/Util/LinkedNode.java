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
public class LinkedNode<T> {
    private T data;
    private LinkedNode<T> next;
    private LinkedNode<T> prev;

    public LinkedNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public LinkedNode(T data, LinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public LinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}