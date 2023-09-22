/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
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
