 /**
 * Name: Aragon, Danielle John P.
 * Date: September 22, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
  *
  * Algorithm: MyFixedSizeArrayListDemo
  * Initialization
  *
  * Create a class named MyFixedSizeArrayListDemo.
  * Main Method
  *
  * Define a main method inside the MyFixedSizeArrayListDemo class with the following steps:
  * Create a Scanner object named scanner to read user input.
  * Declare a variable propertyList of type MyList<Property> and initialize it with a new instance of MyFixedSizeArrayList.
  * Declare an integer variable choice and initialize it to 0.
  * Start a do-while loop with the condition (choice != 3) to repeatedly display the Property Management Menu and process user input:
  * Display the Property Management Menu with options to add a Property, view the Property List, and exit.
  * Prompt the user to enter their choice.
  * Read the user's choice into the choice variable.
  * Consume the newline character.
  * Use a switch statement to perform the following actions based on choice:
  * Case 1:
  * Call the readPropertyDetails method to read property details from the user's input.
  * Create a new Property object from the input details.
  * Try to insert the Property object into the propertyList using the insert method.
  * Handle a ListOverflowException if thrown, displaying "Error: {exception message}."
  * Display "Property added."
  * Case 2:
  * Display "Property List:"
  * Display the contents of propertyList using the toString method.
  * Case 3:
  * Display "Exiting the Property Management App."
  * Default:
  * Display "Invalid choice. Please try again."
  * Catch exceptions:
  * If a ListOverflowException is thrown, display "Error: {exception message}."
  * If a NoSuchElementException is thrown, display "Error: {exception message}."
  * If any other unexpected exception occurs, display "An unexpected error occurred: {exception message}."
  * readPropertyDetails Method
  *
  * Define a private method named readPropertyDetails that takes a Scanner object scanner as a parameter.
  * Inside the method, prompt the user to enter property details (e.g., model, color, status).
  * Read the user's input into a propertyDetails variable.
  * Create a new Property object from the propertyDetails.
  * Return the Property object.
  *
 */
 package prelim.Tester;

 import prelim.Util.ListOverflowException;
 import prelim.Util.MyList;
 import prelim.Util.Property;
 import prelim.ArrayList.MyFixedSizeArrayList;

 import java.util.NoSuchElementException;
 import java.util.Scanner;

/**
 * This class demonstrates the use of a fixed-size ArrayList for managing properties.
 */
public class MyFixedSizeArrayListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyList<Property> propertyList = new MyFixedSizeArrayList<>();

        int choice = 0;
        do {
            try {
                // Display the prelim.Util.Property Management Menu
                System.out.println("\nprelim.Util.Property Management Menu:");
                System.out.println("1. Add prelim.Util.Property");
                System.out.println("2. View prelim.Util.Property List");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                // Read user choice
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        // Read property details from the user and add to the list
                        Property property = readPropertyDetails(scanner);
                        propertyList.insert(property);
                        System.out.println("prelim.Util.Property added.");
                        break;

                    case 2:
                        // Display the list of properties
                        System.out.println("prelim.Util.Property List:");
                        System.out.println(propertyList.toString());
                        break;

                    case 3:
                        System.out.println("Exiting the prelim.Util.Property Management App.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (ListOverflowException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        } while (choice != 3);

        scanner.close();
    }

    /**
     * Reads property details from the user's input.
     *
     * @param scanner The Scanner object used for input.
     * @return A prelim.Util.Property object created from the input details.
     */
    private static Property readPropertyDetails(Scanner scanner) {
        System.out.print("Enter property details (e.g., model, color, status): ");
        String propertyDetails = scanner.nextLine();
        return new Property(propertyDetails);
    }
}
