/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: DoublyLinkedCircularList
 *
 * Initialization
 *
 * Create a class named DoublyLinkedCircularList with a type parameter T.
 * Declare an instance variable head of type LinkedNode<T> to represent the head of the circular doubly linked list.
 * Declare an integer variable size to keep track of the number of elements in the list.
 * Constructor
 *
 * Create a constructor for DoublyLinkedCircularList with no parameters.
 * Inside the constructor:
 * Initialize the head to null since the list is initially empty.
 * Set size to 0 to indicate an empty list.
 * isEmpty
 *
 * Define a method isEmpty that takes no parameters and returns a boolean.
 * This method should return true if the list is empty (head is null), otherwise, return false.
 * insert
 *
 * Define a method insert that takes an element of type T as a parameter.
 * Call the addAtHead method to insert the element at the head of the list.
 * getElement
 *
 * Define a method getElement that takes an element of type T as a parameter and throws a NoSuchElementException.
 * Initialize a current variable to head.
 * Use a do-while loop to iterate through the list:
 * If the data of the current node equals the given data, return the data.
 * Move to the next node by updating current to the next node.
 * Repeat the loop until current becomes equal to head.
 * If the element is not found, throw a NoSuchElementException.
 * delete
 *
 * Define a method delete that takes an element of type T as a parameter and returns a string.
 * Initialize a current variable to head.
 * Use a do-while loop to iterate through the list:
 * If the data of the current node equals the given data, do the following:
 * Store the data of the current node in deletedData.
 * If the current node is the head, call deleteFromHead to remove it.
 * Otherwise, adjust the pointers of the previous and next nodes to bypass the current node.
 * Decrement the size.
 * Return a message indicating the deletion.
 * Move to the next node by updating current to the next node.
 * Repeat the loop until current becomes equal to head.
 * If the element is not found, return a message indicating that the element was not found.
 * search
 *
 * Define a method search that takes an element of type T as a parameter and returns an integer.
 * Initialize a current variable to head.
 * Initialize an index variable to 0.
 * Use a do-while loop to iterate through the list:
 * If the data of the current node equals the given data, return the index.
 * Move to the next node by updating current to the next node and increment index.
 * Repeat the loop until current becomes equal to head.
 * If the element is not found, return -1.
 * addAtHead
 *
 * Define a method addAtHead that takes an element of type T as a parameter.
 * Create a new LinkedNode with the given data.
 * If the list is empty, set the next and previous references of the new node to itself.
 * Otherwise, adjust the pointers of the new node, the current head, and the previous tail to insert the new node at the head.
 * Increment the size.
 * addAtTail
 *
 * Define a method addAtTail that takes an element of type T as a parameter.
 * Create a new LinkedNode with the given data.
 * If the list is empty, set the next and previous references of the new node to itself.
 * Otherwise, adjust the pointers of the new node, the current head, and the previous tail to insert the new node at the tail.
 * Increment the size.
 * deleteFromHead
 *
 * Define a method deleteFromHead that deletes the element from the head of the list.
 * If the list is empty, throw a NoSuchElementException.
 * If the head is the only node in the list, set head to null.
 * Otherwise, adjust the pointers of the new head, the previous tail, and the current head to remove the old head.
 * Decrement the size.
 * Return the data of the deleted element.
 * getSize
 *
 * Define a method getSize that takes no parameters and returns an integer.
 * This method should return the current size of the list, which is stored in the size variable.
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
 * If the list is not empty, use a do-while loop to iterate through the list, appending data to the StringBuilder with " <-> " as a separator.
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
import prelim.Util.LinkedNode;
import prelim.Util.ListOverflowException;
import prelim.Util.MyList;

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
     * Creates a new instance of the prelim.prelim.LinkedList.LinkedList.DoublyLinkedCircularList.
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
            do {
                string.append(current.getData().toString()).append(" <-> ");
                current = current.getNext();
            } while (current != head);
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
