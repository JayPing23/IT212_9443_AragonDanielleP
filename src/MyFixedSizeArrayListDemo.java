/**
 * Name: Aragon, Danielle John P.
 * Date: September 22, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 */
import java.util.Scanner;
import java.util.NoSuchElementException;

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
                // Display the Property Management Menu
                System.out.println("\nProperty Management Menu:");
                System.out.println("1. Add Property");
                System.out.println("2. View Property List");
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
                        System.out.println("Property added.");
                        break;

                    case 2:
                        // Display the list of properties
                        System.out.println("Property List:");
                        System.out.println(propertyList.toString());
                        break;

                    case 3:
                        System.out.println("Exiting the Property Management App.");
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
     * @return A Property object created from the input details.
     */
    private static Property readPropertyDetails(Scanner scanner) {
        System.out.print("Enter property details (e.g., model, color, status): ");
        String propertyDetails = scanner.nextLine();
        return new Property(propertyDetails);
    }
}
