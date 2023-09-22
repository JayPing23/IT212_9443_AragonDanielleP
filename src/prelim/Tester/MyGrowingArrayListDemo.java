package prelim.Tester; /**
 * Name: Aragon, Danielle John P.
 * Date: September 22, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 */

import prelim.Util.ListOverflowException;
import prelim.Util.MyList;
import prelim.ArrayList.MyGrowingArrayList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyGrowingArrayListDemo {
    public static void main(String[] args) throws ListOverflowException {
        Scanner scanner = new Scanner(System.in);
        MyList<String> taskList = new MyGrowingArrayList<>();

        int choice;
        do {
            System.out.println("\nCourse Task Manager Menu:");
            System.out.println("1. Add Completed Task");
            System.out.println("2. View Completed Task List");
            System.out.println("3. Search Completed Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Completed Task
                    String taskDetails = readTaskDetails(scanner);
                    taskList.insert(taskDetails);
                    System.out.println("Completed Task added.");
                    break;

                case 2:
                    // View Completed Task List
                    System.out.println("Completed Task List:");
                    System.out.println(taskList.toString());
                    break;

                case 3:
                    // Search Completed Task
                    System.out.print("Enter task details to search: ");
                    String searchDetails = scanner.nextLine();
                    try {
                        String foundTask = taskList.getElement(searchDetails);
                        System.out.println("Found Completed Task: " + foundTask);
                    } catch (NoSuchElementException e) {
                        System.out.println("Completed Task not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Course Task Manager.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static String readTaskDetails(Scanner scanner) {
        System.out.print("Enter task details (e.g., project name, date assigned, date submitted): ");
        return scanner.nextLine();
    }
}
