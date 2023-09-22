 /**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
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
