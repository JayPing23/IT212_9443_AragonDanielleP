package prelim.Tester; /**
 * Name: Aragon, Danielle John P.
 * Date: September 22, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: MyGrowingArrayListDemo
 *
 * Initialization
 *
 * Create a class named MyGrowingArrayListDemo.
 * Main Method
 *
 * Define a main method inside the MyGrowingArrayListDemo class with the following steps:
 * Create a Scanner object named scanner to read user input.
 * Declare a variable taskList of type MyList<String> and initialize it with a new instance of MyGrowingArrayList.
 * Declare an integer variable choice and initialize it to 0.
 * Start a do-while loop with the condition (choice != 4) to repeatedly display the Course Task Manager Menu and process user input:
 * Display the Course Task Manager Menu with options to add a completed task, view the completed task list, search for a completed task, and exit.
 * Prompt the user to enter their choice.
 * Read the user's choice into the choice variable.
 * Consume the newline character.
 * Use a switch statement to perform the following actions based on choice:
 * Case 1:
 * Call the readTaskDetails method to read task details from the user's input.
 * Insert the task details into the taskList using the insert method.
 * Display "Completed Task added."
 * Case 2:
 * Display "Completed Task List:"
 * Display the contents of taskList using the toString method.
 * Case 3:
 * Prompt the user to enter task details to search.
 * Read the user's input into the searchDetails variable.
 * Try to get the element from taskList based on searchDetails using the getElement method.
 * If found, display "Found Completed Task: {foundTask}" where {foundTask} is the task found.
 * If not found, display "Completed Task not found."
 * Case 4:
 * Display "Exiting the Course Task Manager."
 * Default:
 * Display "Invalid choice. Please try again."
 * readTaskDetails Method
 *
 * Define a private method named readTaskDetails that takes a Scanner object scanner as a parameter.
 * Inside the method, prompt the user to enter task details (e.g., project name, date assigned, date submitted).
 * Read the user's input into a taskDetails variable.
 * Return the taskDetails as a string.
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
