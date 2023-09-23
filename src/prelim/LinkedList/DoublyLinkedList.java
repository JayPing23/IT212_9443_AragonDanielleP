/**
 * Name: Aragon, Danielle John P.
 * Date: September 21, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 * Algorithm: DoublyLinkedList
 *
 * Initialization
 *
 * Create a class named DoublyLinkedList with a type parameter T.
 * Declare two instance variables: head and tail of type LinkedNode<T> to represent the head and tail of the doubly linked list.
 * Initialize both head and tail to null since the list is initially empty.
 * getSize
 *
 * Define a method getSize that takes no parameters and returns an integer.
 * Initialize an integer variable size to 0.
 * Initialize a current variable to head.
 * Use a while loop to iterate through the list:
 * Increment size by 1 for each node in the list.
 * Move to the next node by updating current to the next node.
 * Repeat the loop until current becomes null.
 * Return the size.
 * insert
 *
 * Define a method insert that takes an element of type T as a parameter.
 * Call the addAtTail method to insert the element at the tail of the list.
 * getElement
 *
 * Define a method getElement that takes an element of type T as a parameter and throws a NoSuchElementException.
 * Initialize a current variable to head.
 * Use a while loop to iterate through the list:
 * If the data of the current node equals the given data, return the data of the current node.
 * Move to the next node by updating current to the next node.
 * Repeat the loop until current becomes null.
 * If the element is not found, throw a NoSuchElementException.
 * delete
 *
 * Define a method delete that takes an element of type T as a parameter and returns a string.
 * Initialize a current variable to head and a prev variable to null.
 * Use a while loop to iterate through the list:
 * If the data of the current node equals the given data, do the following:
 * Store the data of the current node in deletedData.
 * If prev is not null, update the next reference of prev to skip the current node.
 * If the current node is the head, update the head to the next node.
 * If the current node is the tail, update the tail to the previous node (which might be null).
 * Return a message indicating the deletion.
 * Update prev to the current node and move to the next node by updating current to the next node.
 * Repeat the loop until current becomes null.
 * If the element is not found, return a message indicating that the element was not found.
 * isEmpty
 *
 * Define a method isEmpty that takes no parameters and returns a boolean.
 * This method should return true if the head is null, indicating that the list is empty, otherwise, return false.
 * addAtHead
 *
 * Define a method addAtHead that takes an element of type T as a parameter.
 * Create a new LinkedNode with the given data.
 * If the list is empty, set both head and tail to the new node.
 * Otherwise, set the next reference of the new node to the current head.
 * Update the head to the new node.
 * addAtTail
 *
 * Define a method addAtTail that takes an element of type T as a parameter.
 * Create a new LinkedNode with the given data.
 * If the list is empty, set both head and tail to the new node.
 * Otherwise, set the next reference of the current tail to the new node.
 * Update the tail to the new node.
 * deleteFromHead
 *
 * Define a method deleteFromHead that deletes the head element from the list and returns its data.
 * If the list is empty (head is null), throw a NoSuchElementException.
 * Store the data of the current head in a variable data.
 * If the head is also the tail (i.e., there is only one node), set both head and tail to null.
 * Otherwise, update the head to the next node.
 * Return the data of the deleted element.
 * search
 *
 * Define a method search that takes an element of type T as a parameter and returns an integer.
 * Initialize a current variable to head.
 * Initialize an index variable to 0.
 * Use a while loop to iterate through the list:
 * If the data of the current node equals the given data, return the index.
 * Move to the next node by updating current to the next node.
 * Increment index by 1.
 * Repeat the loop until current becomes null.
 * If the element is not found, return -1.
 * getAtIndex
 *
 * Define a method getAtIndex that takes an integer index as a parameter and throws an IndexOutOfBoundsException.
 * Check if the index is valid (within the range [0, size)).
 * Initialize a current variable to head.
 * Use a loop to traverse the list to the node at the specified index.
 * Return the data of the node at the specified index.
 * If the index is out of bounds, throw an IndexOutOfBoundsException.
 * toString
 *
 * Define a method toString that takes no parameters and returns a string.
 * Create a StringBuilder to build a string representation of the list.
 * Initialize a node variable to head.
 * Use a while loop to iterate through the list:
 * Append the data of the current node to the StringBuilder.
 * If the current node is not the last node, append " <-> ".
 * Move to the next node by updating node to the next node.
 * Repeat the loop until node becomes null.
 * Return the resulting string.
 * contains
 *
 * Define a method contains that takes an element of type T as a parameter and returns a boolean.
 * Currently, this method is not implemented and always returns false.
 * remove
 *
 * Define a method remove that takes an element of type T as a parameter and returns a boolean.
 * Currently, this method is not implemented and always returns false.
 */
package prelim.LinkedList;
import prelim.Util.*;

import java.util.NoSuchElementException;

/**
 * Represents a doubly linked list.
 *
 * @param <T> The type of elements stored in the list.
 */
public class DoublyLinkedList<T> implements MyList<T> {
    private LinkedNode<T> head;
    private LinkedNode<T> tail;

    /**
     * Creates a new instance of prelim.LinkedList.DoublyLinkedList.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Gets the size of the list.
     *
     * @return The size of the list.
     */
    @Override
    public int getSize() {
        int size = 0;
        LinkedNode<T> current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    /**
     * Inserts an element at the tail of the list.
     *
     * @param data The data to be inserted.
     * @throws ListOverflowException if the list exceeds its capacity (unbounded list).
     */
    @Override
    public void insert(T data) throws ListOverflowException {
        addAtTail(data);
    }

    /**
     * Gets an element from the list based on its data.
     *
     * @param data The data to search for.
     * @return The element with the specified data.
     * @throws NoSuchElementException if the element is not found.
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        LinkedNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current.getData();
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("Element not found");
    }

    /**
     * Deletes an element from the list based on its data.
     *
     * @param data The data of the element to delete.
     * @return A message indicating the deletion.
     */
    @Override
    public String delete(T data) {
        LinkedNode<T> current = head;
        LinkedNode<T> prev = null;

        while (current != null) {
            if (current.getData().equals(data)) {
                T deletedData = current.getData();

                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() == null) {
                    tail = prev;
                }

                return "Deleted element: " + deletedData;
            }

            prev = current;
            current = current.getNext();
        }

        return "Element not found";
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Adds an element at the head of the list.
     *
     * @param data The data to be added.
     */
    public void addAtHead(T data) {
        LinkedNode<T> newNode = new LinkedNode<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    /**
     * Adds an element at the tail of the list.
     *
     * @param data The data to be added.
     */
    public void addAtTail(T data) {
        LinkedNode<T> newNode = new LinkedNode<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    /**
     * Deletes the head element from the list.
     *
     * @return The data of the deleted element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T deleteFromHead() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.getData();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        return data;
    }

    /**
     * Searches for an element in the list based on its data.
     *
     * @param data The data to search for.
     * @return The index of the element in the list, or -1 if not found.
     */
    @Override
    public int search(T data) {
        LinkedNode<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    /**
     * Gets an element from the list based on its index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T getAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        LinkedNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }


    /**
     * Generates a string representation of the list.
     *
     * @return A string representing the elements in the list.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        LinkedNode<T> node = head;

        while (node != null) {
            string.append(node.getData().toString());
            if (node.getNext() != null) {
                string.append(" <-> ");
            }
            node = node.getNext();
        }

        return string.toString();
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public boolean remove(T data) {
        return false;
    }
}
