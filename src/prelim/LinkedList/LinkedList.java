/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: LinkedList
 *
 * Initialization
 *
 * Create a class named LinkedList with a type parameter T.
 * Declare two instance variables: head of type LinkedNode<T> to represent the head of the singly linked list and currentIndex of type integer to keep track of the current index of the list.
 * Initialize head to null since the list is initially empty, and currentIndex to -1.
 * getSize
 *
 * Define a method getSize that takes no parameters and returns an integer.
 * Return the value of currentIndex + 1 to represent the size of the list based on the current index.
 * insert
 *
 * Define a method insert that takes an element of type T as a parameter and throws a ListOverflowException.
 * Call the addAtTail method to insert the element at the tail of the list since the list is unbounded.
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
 * If prev is not null, update the next reference of prev to skip the current node.
 * Update the currentIndex by decrementing it.
 * Return a message indicating the deletion of the element.
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
 * Create a new LinkedNode with the given data and the current head as the next node.
 * Update head to the new node.
 * Increment currentIndex by 1 to reflect the addition at the head.
 * addAtTail
 *
 * Define a method addAtTail that takes an element of type T as a parameter.
 * Create a new LinkedNode with the given data.
 * If the list is empty, set head to the new node.
 * Otherwise, traverse the list to find the current tail node (the node with next as null).
 * Set the next reference of the current tail node to the new node.
 * Increment currentIndex by 1 to reflect the addition at the tail.
 * deleteFromHead
 *
 * Define a method deleteFromHead that deletes the head element from the list and returns its data.
 * If the list is empty (head is null), throw a NoSuchElementException.
 * Store the data of the current head in a variable data.
 * Update head to the next node.
 * Decrement currentIndex by 1 to reflect the deletion from the head.
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
 * toString
 *
 * Define a method toString that takes no parameters and returns a string.
 * Create a StringBuilder to build a string representation of the list.
 * Initialize a node variable to head.
 * Initialize an index variable to 0.
 * Use a while loop to iterate through the list:
 * If index is greater than 0, append " -> " to the StringBuilder to separate elements.
 * Append the data of the current node to the StringBuilder.
 * Move to the next node by updating node to the next node.
 * Increment index by 1.
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
 * Represents a singly linked list.
 *
 * @param <T> The type of elements stored in the list.
 */
public class LinkedList<T> implements MyList<T> {
    private LinkedNode<T> head;
    private int currentIndex; // Added index variable

    /**
     * Creates a new instance of prelim.LinkedList.LinkedList.
     */
    public LinkedList() {
        head = null;
        currentIndex = -1; // Initialize index to -1
    }

    /**
     * Gets the size of the list.
     *
     * @return The size of the list.
     */
    @Override
    public int getSize() {
        return currentIndex + 1; // Return the size based on the current index
    }

    /**
     * Inserts an element at the tail of the list.
     *
     * @param data The data to be inserted.
     * @throws ListOverflowException if the list exceeds its capacity (unbounded list).
     */
    @Override
    public void insert(T data) throws ListOverflowException {
        addAtTail(data); // Insert at the tail, as the list is unbounded
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
                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                currentIndex--; // Decrement index when deleting an element
                return "Deleted element: " + current.getData().toString();
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
        head = new LinkedNode<>(data, head);
        currentIndex++; // Increment index when adding at head
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
            LinkedNode<T> tail = head;
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            tail.setNext(newNode);
        }
        currentIndex++; // Increment index when adding at tail
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
        head = head.getNext();
        currentIndex--; // Decrement index when deleting from head
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

        return -1; // Element not found
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
        int index = 0;
        while (node != null) {
            if (index > 0) {
                string.append(" -> "); // Add arrow between elements
            }
            string.append(node.getData().toString());
            node = node.getNext();
            index++; // Increment index
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
