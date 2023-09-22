/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 */
import java.util.NoSuchElementException;

/**
 * Represents a doubly linked circular list.
 *
 * @param <T> The type of elements stored in the list.
 */
public class DoublyLinkedCircularList<T> implements MyList<T> {
    private LinkedNode<T> head;
    private int size;

    /**
     * Creates a new instance of the DoublyLinkedCircularList.
     */
    public DoublyLinkedCircularList() {
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
        do {
            if (current.getData().equals(data)) {
                return current.getData();
            }
            current = current.getNext();
        } while (current != head);
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
        LinkedNode<T> current = head;
        do {
            if (current.getData().equals(data)) {
                T deletedData = current.getData();
                if (current == head) {
                    deleteFromHead();
                } else {
                    LinkedNode<T> prevNode = current.getPrev();
                    LinkedNode<T> nextNode = current.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    size--;
                }
                return "Deleted element: " + deletedData.toString();
            }
            current = current.getNext();
        } while (current != head);
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
        do {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        } while (current != head);
        return -1;
    }

    /**
     * Adds an element at the head of the list.
     *
     * @param data The data to be added.
     */
    public void addAtHead(T data) {
        LinkedNode<T> newNode = new LinkedNode<T>(data);
        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = newNode;
        } else {
            LinkedNode<T> tail = head.getPrev();
            newNode.setNext(head);
            newNode.setPrev(tail);
            head.setPrev(newNode);
            tail.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the tail of the list.
     *
     * @param data The data to be added.
     */
    public void addAtTail(T data) {
        LinkedNode<T> newNode = new LinkedNode<T>(data);
        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = newNode;
        } else {
            LinkedNode<T> tail = head.getPrev();
            newNode.setNext(head);
            newNode.setPrev(tail);
            head.setPrev(newNode);
            tail.setNext(newNode);
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
        if (head.getNext() == head) {
            head = null;
        } else {
            LinkedNode<T> tail = head.getPrev();
            LinkedNode<T> newHead = head.getNext();
            newHead.setPrev(tail);
            tail.setNext(newHead);
            head = newHead;
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
     * Returns a string representation of the list.
     *
     * @return A string representing the elements of the list.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (!isEmpty()) {
            LinkedNode<T> current = head;
            do {
                string.append(current.getData().toString()).append(" <-> ");
                current = current.getNext();
            } while (current != head);
        }
        return string.toString();
    }
}
