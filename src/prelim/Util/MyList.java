/**
 * Name: Aragon, Danielle John P.
 * Date: September 09, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: MyList Interface
 *
 * Interface Definition
 *
 * Create an interface named MyList with a generic type parameter E.
 * Method getSize
 *
 * Define a method getSize with the following signature:
 * int getSize()
 * Purpose: This method is used to retrieve the size of the list.
 * Return Value: An integer representing the size of the list.
 * Method isEmpty
 *
 * Define a method isEmpty with the following signature:
 * boolean isEmpty()
 * Purpose: This method is used to check if the list is empty.
 * Return Value: A boolean indicating whether the list is empty (true) or not (false).
 * Method insert
 *
 * Define a method insert with the following signature:
 * void insert(E data) throws ListOverflowException
 * Purpose: This method is used to insert an element of type E into the list.
 * Parameters:
 * data: The data of type E to be inserted into the list.
 * Exceptions:
 * ListOverflowException: Thrown if the list exceeds its capacity (optional).
 * Method getElement
 *
 * Define a method getElement with the following signature:
 * E getElement(E data) throws NoSuchElementException
 * Purpose: This method is used to get an element from the list based on its data.
 * Parameters:
 * data: The data of type E to search for.
 * Exceptions:
 * NoSuchElementException: Thrown if the element is not found in the list.
 * Return Value: An element of type E with the specified data.
 * Method delete
 *
 * Define a method delete with the following signature:
 * String delete(E data)
 * Purpose: This method is used to delete an element from the list based on its data.
 * Parameters:
 * data: The data of type E of the element to delete.
 * Return Value: A string message indicating the deletion or a message indicating that the element was not found.
 * Method search
 *
 * Define a method search with the following signature:
 * int search(E data)
 * Purpose: This method is used to search for an element in the list based on its data and return its index.
 * Parameters:
 * data: The data of type E to search for.
 * Return Value: An integer representing the index of the element in the list or -1 if not found.
 * Method toString
 *
 * Define a method toString with the following signature:
 * String toString()
 * Purpose: This method is used to generate a string representation of the elements in the list.
 * Return Value: A string representing the elements in the list.
 * Additional Methods (Optional)
 *
 * You can include additional methods in the interface, such as contains and remove, based on your specific requirements for school management.
 */

package prelim.Util;
import java.util.NoSuchElementException;

public interface MyList<E> {
    int getSize();
    boolean isEmpty();
    void insert(E data) throws ListOverflowException;
    E getElement(E data) throws NoSuchElementException;
    String delete(E data);
    int search(E data);
    String toString();

    // Additional methods for school management
    boolean contains(E data);
    boolean remove(E data);

}

