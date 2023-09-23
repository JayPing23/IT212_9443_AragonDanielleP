/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: MyFixedSizeArrayList
 *
 * +Initialization
 * Create a class named MyFixedSizeArrayList with a type parameter E.
 * Define a constant MAX_SIZE with a value of 5 to represent the maximum size of the array.
 * Declare an array of type Property[] to store elements.
 * Initialize an integer variable size to 0 to keep track of the number of elements in the array.
 *
 * +Constructor
 * Create a constructor for MyFixedSizeArrayList with no parameters.
 * Inside the constructor:
 * Initialize the array to a new Property array of size MAX_SIZE.
 * Set size to 0 to indicate an empty list.
 *
 * +getSize
 * Define a method getSize that takes no parameters and returns an integer.
 * This method should return the current size of the list, which is stored in the size variable.
 *
 * +isEmpty
 * Define a method isEmpty that takes no parameters and returns a boolean.
 * This method should return true if the list is empty (size is 0), otherwise, return false.
 *
 * +insert
 * Define a method insert that takes an element of type E as a parameter and throws a ListOverflowException.
 * Check if the current size of the list (size) is greater than or equal to MAX_SIZE.
 * If the list is full, throw a ListOverflowException.
 * Otherwise, add the element to the array at the position indicated by size, and increment size by 1.
 *
 *
 * +getElement
 * Define a method getElement that takes an element of type E as a parameter and throws a NoSuchElementException.
 * Iterate through the elements in the array to find an element that equals the given data.
 * If found, return the element.
 * If not found, throw a NoSuchElementException.
 *
 *
 * +delete
 * Define a method delete that takes an element of type E as a parameter and returns a string.
 * Iterate through the elements in the array to find an element that equals the given data.
 * If found, remove the element from the list by shifting the remaining elements to fill the gap.
 * Decrement size by 1.
 * Return a message indicating the deletion.
 * If the element is not found, return a message indicating that the element was not found.
 *
 * +search
 * Define a method search that takes an element of type E as a parameter and returns an integer.
 * Iterate through the elements in the array to find the index of the first element that equals the given data.
 * If found, return the index. If not found, return -1.
 *
 * +toString
 * Define a method toString that takes no parameters and returns a string.
 * Create a StringBuilder to build a string representation of the list.
 * Iterate through the elements in the array and append them to the StringBuilder with " -> " as a separator.
 * Return the resulting string.
 *
 * +contains
 * Define a method contains that takes an element of type E as a parameter and returns a boolean.
 * Currently, this method is not implemented and always returns false.
 *
 * +remove
 * Define a method remove that takes an element of type E as a parameter and returns a boolean.
 * Currently, this method is not implemented and always returns false.
 *
 * +getAtIndex
 * Define a method getAtIndex that takes an integer index as a parameter and throws an IndexOutOfBoundsException.
 * Check if the index is valid (within the range [0, size)).
 * If valid, return the element at the specified index.
 * If the index is out of bounds, throw an IndexOutOfBoundsException.
 */
package prelim.ArrayList;

import prelim.Util.ListOverflowException;
import prelim.Util.MyList;
import prelim.Util.Property;

import java.util.NoSuchElementException;

/**
 * MyFixedSizeArrayList is an implementation of the MyList interface with a fixed maximum size.
 * It stores elements of type Property and provides basic list operations.
 *
 * @param <E> The type of elements to be stored in the list.
 */
public class MyFixedSizeArrayList<E> implements MyList<E> {
    // Maximum size of the list
    private static final int MAX_SIZE = 5;

    // Array to store elements
    private Property[] array;

    // Current size of the list
    private int size;

    /**
     * Constructs a new MyFixedSizeArrayList with a maximum size of MAX_SIZE.
     */
    public MyFixedSizeArrayList() {
        array = new Property[MAX_SIZE];
        size = 0;
    }

    /**
     * Returns the current size of the list.
     *
     * @return The size of the list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Inserts an element into the list.
     *
     * @param data The element to be inserted.
     * @throws ListOverflowException if the list is full and cannot insert more elements.
     */
    @Override
    public void insert(E data) throws ListOverflowException {
        if (size >= MAX_SIZE) {
            throw new ListOverflowException("List is full. Cannot insert.");
        }
        array[size] = (Property) data;
        size++;
    }

    /**
     * Retrieves an element from the list.
     *
     * @param data The element to be retrieved.
     * @return The element if found.
     * @throws NoSuchElementException if the element is not found in the list.
     */
    @Override
    public E getElement(E data) throws NoSuchElementException {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return (E) array[i];
            }
        }
        throw new NoSuchElementException("Element not found.");
    }

    /**
     * Deletes an element from the list.
     *
     * @param data The element to be deleted.
     * @return A message indicating the deleted element or "Element not found" if not found.
     */
    @Override
    public String delete(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                String deletedName = array[i].toString();
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return "Deleted property: " + deletedName;
            }
        }
        return "Element not found.";
    }

    /**
     * Searches for an element in the list.
     *
     * @param data The element to be searched.
     * @return The index of the element if found, or -1 if not found.
     */
    @Override
    public int search(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return A string representing the list elements.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                string.append(" -> ");
            }
            string.append(array[i].toString());
        }
        return string.toString();
    }

    /**
     * Checks if the list contains a specific element.
     *
     * @param data The element to be checked.
     * @return True if the element is found, otherwise false.
     */
    @Override
    public boolean contains(E data) {
        return false;
    }

    /**
     * Removes a specific element from the list.
     *
     * @param data The element to be removed.
     * @return True if the element is removed, otherwise false.
     */
    @Override
    public boolean remove(E data) {
        return false;
    }

    /**
     * Retrieves an element at a specific index in the list.
     *
     * @param index The index of the element to be retrieved.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E getAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (E) array[index];
    }
}


