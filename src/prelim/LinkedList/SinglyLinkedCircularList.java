/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: SinglyLinkedCircularList
 *
 * Initialization
 *
 * Create a class named SinglyLinkedCircularList with a type parameter T.
 * Declare two instance variables: head of type LinkedNode<T> to represent the head of the singly linked circular list and size of type integer to keep track of the number of elements in the list.
 * Initialize head to null since the list is initially empty, and size to 0.
 * isEmpty
 *
 * Define a method isEmpty that takes no parameters and returns a boolean.
 * This method should return true if the head is null, indicating that the list is empty; otherwise, return false.
 * insert
 *
 * Define a method insert that takes an element of type T as a parameter and throws a ListOverflowException.
 * Call the addAtHead method to insert the element at the head of the circular list.
 * getElement
 *
 * Define a method getElement that takes an element of type T as a parameter and throws a NoSuchElementException.
 * Initialize a current variable to head.
 * Initialize a count variable to 0.
 * Use a while loop to iterate through the list:
 * If the data of the current node equals the given data, return the data of the current node.
 * Move to the next node by updating current to the next node.
 * Increment count by 1.
 * Repeat the loop until count reaches the size of the list.
 * If the element is not found, throw a NoSuchElementException.
 * delete
 *
 * Define a method delete that takes an element of type T as a parameter and returns a string.
 * Check if the list is empty (head is null). If it is, return "Element not found."
 * Check if the head contains the given data. If it does, call the deleteFromHead method to delete the head node and return a message indicating the deletion.
 * Initialize a current variable to head.
 * Initialize a count variable to 0.
 * Use a while loop to iterate through the list:
 * If the data of the next node equals the given data, do the following:
 * Update the next reference of the current node to skip the next node.
 * Decrement size by 1.
 * Return a message indicating the deletion of the element.
 * Move to the next node by updating current to the next node.
 * Increment count by 1.
 * Repeat the loop until count reaches size - 1.
 * If the element is not found, return "Element not found."
 * search
 *
 * Define a method search that takes an element of type T as a parameter and returns an integer.
 * Initialize a current variable to head.
 * Initialize an index variable to 0.
 * Use a while loop to iterate through the list:
 * If the data of the current node equals the given data, return the index.
 * Move to the next node by updating current to the next node.
 * Increment index by 1.
 * Repeat the loop until index reaches size.
 * If the element is not found, return -1.
 * addAtHead
 *
 * Define a method addAtHead that takes an element of type T as a parameter.
 * Create a new LinkedNode with the given data.
 * If the list is empty, set the next reference of the new node to itself and update head to the new node.
 * If the list is not empty, traverse the list to find the current tail node (the node with next as head).
 * Set the next reference of the new node to head and update the next reference of the tail node to the new node.
 * Update head to the new node.
 * Increment size by 1 to reflect the addition at the head.
 * deleteFromHead
 *
 * Define a method deleteFromHead that deletes the head element from the list and returns its data.
 * Check if the list is empty (head is null). If it is, throw a NoSuchElementException with the message "List is empty."
 * Store the data of the current head in a variable data.
 * If the list contains only one element (size is 1), set head to null.
 * If the list contains multiple elements, traverse the list to find the current tail node (the node with next as head).
 * Update head to the next node.
 * Update the next reference of the tail node to the new head.
 * Decrement size by 1 to reflect the deletion from the head.
 * Return the data of the deleted element.
 * getSize
 *
 * Define a method getSize that takes no parameters and returns an integer.
 * Return the size of the list.
 * getAtIndex
 *
 * Define a method getAtIndex that takes an integer index as a parameter and throws an IndexOutOfBoundsException.
 * Check if the given index is out of bounds (less than 0 or greater than or equal to size).
 * Initialize a current variable to head.
 * Initialize an count variable to 0.
 * Use a while loop to iterate through the list:
 * If count equals the given index, return the data of the current node.
 * Move to the next node by updating current to the next node.
 * Increment count by 1.
 * Repeat the loop until count reaches the given index.
 * If the index is out of bounds, throw an IndexOutOfBoundsException.
 * toString
 *
 * Define a method toString that takes no parameters and returns a string.
 * Create a StringBuilder to build a string representation of the list.
 * Check if the list is not empty:
 * Initialize a current variable to head.
 * Initialize a count variable to 0.
 * Use a while loop to iterate through the list:
 * If count is greater than 0, append " -> " to the StringBuilder to separate elements.
 * Append the data of the current node to the StringBuilder.
 * Move to the next node by updating current to the next node.
 * Increment count by 1.
 * Repeat the loop until count reaches size.
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
 * Represents a singly linked circular list.
 *
 * @param <T> The type of elements stored in the list.
 */
public class SinglyLinkedCircularList<T> implements MyList<T> {
    private LinkedNode<T> head;
    private int size;

    /**
     * Creates a new instance of the prelim.LinkedList.SinglyLinkedCircularList.
     */
    public SinglyLinkedCircularList() {
        head = null;
        size = 0;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, otherwise false.
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Inserts an element at the head of the list.
     *
     * @param data The data to be inserted.
     * @throws ListOverflowException if the list overflows (not used in this implementation).
     */
    @Override
    public void insert(T data) throws ListOverflowException {
        addAtHead(data);
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
        int count = 0;
        while (count < size) {
            if (current.getData().equals(data)) {
                return current.getData();
            }
            current = current.getNext();
            count++;
        }
        throw new NoSuchElementException("Element not found.");
    }

    /**
     * Deletes an element from the list based on its data.
     *
     * @param data The data to be deleted.
     * @return A message indicating the deleted element.
     */
    @Override
    public String delete(T data) {
        if (isEmpty()) {
            return "Element not found.";
        }

        if (head.getData().equals(data)) {
            deleteFromHead();
            return "Deleted element: " + data.toString();
        }

        LinkedNode<T> current = head;
        int count = 0;

        while (count < size - 1) {
            if (current.getNext().getData().equals(data)) {
                LinkedNode<T> nextNode = current.getNext().getNext();
                current.setNext(nextNode);
                size--;
                return "Deleted element: " + data.toString();
            }
            current = current.getNext();
            count++;
        }

        return "Element not found.";
    }

    /**
     * Searches for an element in the list based on its data.
     *
     * @param data The data to search for.
     * @return The index of the element if found, otherwise -1.
     */
    @Override
    public int search(T data) {
        LinkedNode<T> current = head;
        int index = 0;
        while (index < size) {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    /**
     * Adds an element at the head of the list.
     *
     * @param data The data to be added.
     */
    public void addAtHead(T data) {
        LinkedNode<T> newNode = new LinkedNode<>(data);
        if (isEmpty()) {
            newNode.setNext(newNode);
            head = newNode;
        } else {
            LinkedNode<T> tail = head;
            while (tail.getNext() != head) {
                tail = tail.getNext();
            }
            newNode.setNext(head);
            tail.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Deletes the element from the head of the list.
     *
     * @return The data of the deleted element.
     */
    public T deleteFromHead() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T data = head.getData();

        if (size == 1) {
            head = null;
        } else {
            LinkedNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            head = head.getNext();
            current.setNext(head);
        }
        size--;
        return data;
    }

    /**
     * Gets the size of the list.
     *
     * @return The size of the list.
     */
    public int getSize() {
        return size;
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
     * Returns a string representation of the list.
     *
     * @return A string representing the elements of the list.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (!isEmpty()) {
            LinkedNode<T> current = head;
            int count = 0;
            while (count < size) {
                string.append(current.getData().toString());
                if (count < size - 1) {
                    string.append(" -> ");
                }
                current = current.getNext();
                count++;
            }
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
