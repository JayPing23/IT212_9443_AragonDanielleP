/**
 * Name: Aragon, Danielle John P.
 * Date: September 09, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 */
import java.util.NoSuchElementException;

public interface MyList<E> {
    int getSize();
    boolean isEmpty();
    void insert(E data) throws ListOverflowException;
    E getElement(E data) throws NoSuchElementException;
    String delete(E data);
    int search(E data);
    String toString();
}

