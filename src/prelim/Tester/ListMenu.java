/**
 * Name: Aragon, Danielle John P.
 * Date: September 22, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 * Algorithm: ListMenu
 *
 * Initialization
 *
 * Create a class named ListMenu.
 * Main Method
 *
 * Define a main method inside the ListMenu class with the following steps:
 * Create a Scanner object named scanner to read user input.
 * Declare a variable list of type MyList<String> and initialize it to null. This variable will hold the selected list.
 * Declare an integer variable listChoice.
 * Start a do-while loop with the condition (listChoice != 6) to repeatedly display the list type selection menu and process user input:
 * Display the list type selection menu with options for various list types (e.g., LinkedList, SinglyLinkedList, etc.).
 * Prompt the user to enter their choice.
 * Read the user's choice into the listChoice variable.
 * Consume the newline character.
 * Use a switch statement to perform the following actions based on listChoice:
 * Case 1: Initialize list with a new instance of LinkedList.
 * Case 2: Initialize list with a new instance of SinglyLinkedList.
 * Case 3: Initialize list with a new instance of DoublyLinkedList.
 * Case 4: Initialize list with a new instance of SinglyLinkedCircularList.
 * Case 5: Initialize list with a new instance of DoublyLinkedCircularList.
 * Case 6: Display "Exiting the program."
 * Default: Display "Invalid choice. Please try again."
 * If list is not null (i.e., a list type is selected), call the operateOnList method with the scanner and list as arguments.
 * operateOnList Method
 *
 * Define a private method named operateOnList that takes a Scanner object scanner and a MyList<String> object list as parameters. This method allows the user to perform operations on the selected list.
 * Inside the method, declare an integer variable operationChoice.
 * Start a do-while loop with the condition (operationChoice != 4) to repeatedly display the list operation menu and process user input:
 * Display the list operation menu with options to add an element, delete an element, show the list, and return to list type selection.
 * Prompt the user to enter their choice.
 * Read the user's choice into the operationChoice variable.
 * Consume the newline character.
 * Use a switch statement to perform the following actions based on operationChoice:
 * Case 1:
 * Prompt the user to enter the element to add.
 * Read the user's input into a dataToAdd variable.
 * Try to insert dataToAdd into the list using the insert method.
 * Handle a ListOverflowException if thrown, displaying "List overflow: {exception message}."
 * Display "Element added."
 * Case 2:
 * Prompt the user to enter the element to delete.
 * Read the user's input into a dataToDelete variable.
 * Try to delete dataToDelete from the list using the delete method.
 * Handle a NoSuchElementException if thrown, displaying "Element not found."
 * Display "Element '{deleted element}' deleted."
 * Case 3:
 * Display "List Contents:" and show the contents of the list using the toString method.
 * Case 4:
 * Display "Returning to List Type Selection."
 * Default: Display "Invalid choice. Please try again."
 * Continue the loop until the user chooses option 4 to return to list type selection.
 */
package prelim.Tester;

import prelim.Util.ListOverflowException;
import prelim.Util.MyList;
import prelim.LinkedList.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Represents a menu-driven program for interacting with different types of lists.
 */
public class ListMenu {
    public static void main(String[] args) throws ListOverflowException {
        Scanner scanner = new Scanner(System.in);
        MyList<String> list = null;

        int listChoice;
        do {
            // Display the list type selection menu
            System.out.println("\nSelect a List Type:");
            System.out.println("1. LinkedList");
            System.out.println("2. SinglyLinkedList");
            System.out.println("3. DoublyLinkedList");
            System.out.println("4. SinglyLinkedCircularList");
            System.out.println("5. DoublyLinkedCircularList");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            listChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (listChoice) {
                case 1:
                    list = new LinkedList<>();
                    break;

                case 2:
                    list = new SinglyLinkedList<>();
                    break;

                case 3:
                    list = new DoublyLinkedList<>();
                    break;

                case 4:
                    list = new SinglyLinkedCircularList<>();
                    break;

                case 5:
                    list = new DoublyLinkedCircularList<>();
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            if (list != null) {
                operateOnList(scanner, list);
            }

        } while (listChoice != 6); // Exit the program when the user chooses option 6

        scanner.close();
    }

    /**
     * Allows the user to perform operations on the selected list.
     *
     * @param scanner The Scanner object for user input.
     * @param list    The selected list to operate on.
     * @throws ListOverflowException if a list overflows (not used in this implementation).
     */
    private static void operateOnList(Scanner scanner, MyList<String> list) throws ListOverflowException {
        int operationChoice;
        do {
            // Display the list operation menu
            System.out.println("\nSelect an Operation:");
            System.out.println("1. Add an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Show the list");
            System.out.println("4. Return to List Type Selection");
            System.out.print("Enter your choice: ");

            operationChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (operationChoice) {
                case 1:
                    System.out.print("\nEnter the element to add: ");
                    String dataToAdd = scanner.nextLine();
                    try {
                        list.insert(dataToAdd);
                        System.out.println("Element added.");
                    } catch (ListOverflowException e) {
                        System.out.println("List overflow: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("\nEnter the element to delete: ");
                    String dataToDelete = scanner.nextLine();
                    try {
                        String deletedElement = list.delete(dataToDelete);
                        System.out.println("Element '" + deletedElement + "' deleted.");
                    } catch (NoSuchElementException e) {
                        System.out.println("Element not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nList Contents:");
                    System.out.println(list.toString());
                    break;

                case 4:
                    System.out.println("Returning to List Type Selection.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (operationChoice != 4); // Return to list type selection when the user chooses option 4
    }
}
