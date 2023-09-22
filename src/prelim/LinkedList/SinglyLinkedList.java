/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 */
package prelim.LinkedList;
import prelim.Util.*;
import java.util.NoSuchElementException;

/**
 * Represents a singly linked list.
 *
 * @param <T> The type of elements stored in the list.
 */
public class SinglyLinkedList<T> implements MyList<T> {
    private LinkedNode<T> head;
    private int currentIndex; // Added index variable

    /**
     * Creates a new instance of SinglyLinkedList.
     */
    public SinglyLinkedList() {
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
