 /**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
  *
  * Algorithm: MyGrowingArrayList
  *
  * Initialization
  *
  * Create a class named MyGrowingArrayList with a type parameter E.
  * Define a constant INITIAL_CAPACITY with a value of 5 to represent the initial capacity of the array.
  * Declare an array array of type LinkedNode<E>[] to store elements.
  * Initialize an integer variable size to 0 to keep track of the number of elements in the array.
  * Constructor
  *
  * Create a constructor for MyGrowingArrayList with no parameters.
  * Inside the constructor:
  * Initialize the array to a new LinkedNode<E>[] array of size INITIAL_CAPACITY.
  * Set size to 0 to indicate an empty list.
  * getSize
  *
  * Define a method getSize that takes no parameters and returns an integer.
  * This method should return the current size of the list, which is stored in the size variable.
  * isEmpty
  *
  * Define a method isEmpty that takes no parameters and returns a boolean.
  * This method should return true if the list is empty (size is 0), otherwise, return false.
  * insert
  *
  * Define a method insert that takes an element of type E as a parameter.
  * Check if the current size of the list (size) is greater than or equal to the current capacity of the array.
  * If the array is full, call the resizeArray method to increase its capacity.
  * Add the element to the array at the position indicated by size, and increment size by 1.
  * getElement
  *
  * Define a method getElement that takes an element of type E as a parameter and throws a NoSuchElementException.
  * Iterate through the elements in the array to find a LinkedNode whose data equals the given data.
  * If found, return the data from the LinkedNode.
  * If not found, throw a NoSuchElementException.
  * delete
  *
  * Define a method delete that takes an element of type E as a parameter and returns a string.
  * Iterate through the elements in the array to find a LinkedNode whose data equals the given data.
  * If found, remove the LinkedNode from the list by shifting the remaining elements to fill the gap.
  * Decrement size by 1.
  * Return a message indicating the deletion.
  * If the element is not found, return a message indicating that the element was not found.
  * search
  *
  * Define a method search that takes an element of type E as a parameter and returns an integer.
  * Iterate through the elements in the array to find the index of the first LinkedNode whose data equals the given data.
  * If found, return the index. If not found, return -1.
  * toString
  *
  * Define a method toString that takes no parameters and returns a string.
  * Create a StringBuilder to build a string representation of the list.
  * Iterate through the elements in the array and append their data to the StringBuilder with " -> " as a separator.
  * Return the resulting string.
  * contains
  *
  * Define a method contains that takes an element of type E as a parameter and returns a boolean.
  * Currently, this method is not implemented and always returns false.
  * remove
  *
  * Define a method remove that takes an element of type E as a parameter and returns a boolean.
  * Currently, this method is not implemented and always returns false.
  * getAtIndex
  *
  * Define a method getAtIndex that takes an integer index as a parameter and throws an IndexOutOfBoundsException.
  * Check if the index is valid (within the range [0, size)).
  * If valid, return the data from the LinkedNode at the specified index.
  * If the index is out of bounds, throw an IndexOutOfBoundsException.
  * resizeArray
  *
  * Define a private method resizeArray with no parameters.
  * Calculate the new capacity as twice the current capacity of the array.
  * Create a new LinkedNode<E>[] array with the new capacity.
  * Copy the elements from the current array to the new array using System.arraycopy.
  * Update the array reference to point to the new array.
 */

 package prelim.ArrayList;

import prelim.Util.MyList;
import prelim.Util.LinkedNode;
import java.util.NoSuchElementException;

public class MyGrowingArrayList<E> implements MyList<E> {
    private static final int INITIAL_CAPACITY = 5;
    private LinkedNode<E>[] array;
    private int size;

    public MyGrowingArrayList() {
        array = new LinkedNode[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(E data) {
        if (size >= array.length) {
            resizeArray();
        }
        array[size] = new LinkedNode<>(data);
        size++;
    }

    @Override
    public E getElement(E data) throws NoSuchElementException {
        for (int i = 0; i < size; i++) {
            if (array[i].getData().equals(data)) {
                return array[i].getData();
            }
        }
        throw new NoSuchElementException("Element not found");
    }

    @Override
    public String delete(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].getData().equals(data)) {
                String deletedName = array[i].getData().toString();
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return "Deleted element: " + deletedName;
            }
        }
        return "Element not found.";
    }

    @Override
    public int search(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].getData().equals(data)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                string.append(" -> ");
            }
            string.append(array[i].getData().toString());
        }
        return string.toString();
    }

    @Override
    public boolean contains(E data) {
        return false;
    }

    @Override
    public boolean remove(E data) {
        return false;
    }

    public E getAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index].getData();
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        LinkedNode<E>[] newArray = new LinkedNode[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
