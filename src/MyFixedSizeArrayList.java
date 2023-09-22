/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 */
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList<E> implements MyList<E> {
    private static final int MAX_SIZE = 5;
    private Property[] array;
    private int size;

    public MyFixedSizeArrayList() {
        array = new Property[MAX_SIZE];
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
    public void insert(E data) throws ListOverflowException {
        if (size >= MAX_SIZE) {
            throw new ListOverflowException("List is full. Cannot insert.");
        }
        array[size] = (Property) data;
        size++;
    }

    @Override
    public E getElement(E data) throws NoSuchElementException {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return (E) array[i];
            }
        }
        throw new NoSuchElementException("Element not found.");
    }

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

    @Override
    public int search(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
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
            string.append(array[i].toString());
        }
        return string.toString();
    }
}
