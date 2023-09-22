/**
 * This is a test class for testing the created List DataStructures.
 * Shopping class represents a simple shopping application.
 * It allows users to view products, add them to a cart, and manage the cart.
 * The Shopping class serves as the main entry point for the shopping application. It provides
 * functionality for displaying a list of available products, allowing users to add products to
 * their shopping cart, view the contents of the cart, and remove items from the cart. The application
 * uses list data structures for the product list and cart, and it includes error handling for
 * user input.
 * The main algorithm of the class is as follows:
 * 1. Initialize the list of available products with sample data.
 *    - The initializeProducts method populates the product list with sample Product objects.
 * 2. Display a menu to the user with available options:
 *    - Add Item to cart
 *    - Show Cart (Empty Cart) (if the cart is empty)
 *    - Delete an Item on Cart (if the cart is not empty)
 *    - Exit Application
 * 3. Continuously prompt the user for their choice until they choose to exit the application.
 * 4. Based on the user's choice, the following actions are performed:
 *    - Add Item to cart:
 *      - Display the list of available products.
 *      - Prompt the user to enter the ID of the product they want to add.
 *      - Prompt the user to enter the quantity of the selected product (limited to 1-5).
 *      - If the product is already in the cart, update the quantity; otherwise, add it to the cart.
 *    - Show Cart:
 *      - Display the contents of the shopping cart, including product name, quantity, price, and ID.
 *    - Delete an Item on Cart:
 *      - Display the contents of the shopping cart.
 *      - Prompt the user to enter the ID of the product they want to remove from the cart.
 *      - If the product is found in the cart, remove it; otherwise, display an error message.
 *    - Exit Application: Terminate the application.
 * 5. The class uses list data structures for the product list and cart, such as singly linked lists,
 *    doubly linked lists, growing arrays, and fixed-size arrays. The user can choose which data structure
 *    to use by uncommenting the corresponding lines in the code.
 * 6. Error handling is implemented for user input, ensuring that the user provides valid choices and input
 *    for product selection and quantity.
 * 7. The Utils class is used for formatting currency values.
 *
 *
 */
package prelim.Tester;


import prelim.LinkedList.DoublyLinkedCircularList;
import prelim.Util.ListOverflowException;
import prelim.Util.MyList;
import prelim.Util.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingCart {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Uncomment one of the following data structures you want to test.
     * */
//    private static SinglyLinkedList<Product> products = new SinglyLinkedList<>();
//    private static SinglyLinkedList<Product> cartItems = new SinglyLinkedList<>();

//    private static MyGrowingArrayList<Product> products = new MyGrowingArrayList<>();
//    private static MyGrowingArrayList<Product> cartItems = new MyGrowingArrayList<>();

    private static DoublyLinkedCircularList<Product> products = new DoublyLinkedCircularList<>();
    private static DoublyLinkedCircularList<Product> cartItems = new DoublyLinkedCircularList<>();

//    private static DoublyLinkedList<Product> products = new DoublyLinkedList<>();
//    private static DoublyLinkedList<Product> cartItems = new DoublyLinkedList<>();

//    private static SinglyLinkedCircularList<Product> products = new SinglyLinkedCircularList<>();
//    private static SinglyLinkedCircularList<Product> cartItems = new SinglyLinkedCircularList<>();

//    private static MyFixedSizeArrayList<Product> products = new MyFixedSizeArrayList<>();
//    private static MyFixedSizeArrayList<Product> cartItems = new MyFixedSizeArrayList<>();


    /**
     * Initializes the list of available products.
     *
     * @param products The list to initialize with products.
     * @throws ListOverflowException If there's an issue with the list (will only throw if the data structure used is MyFixedSizeArrayList).
     */
    private static void initializeProducts(MyList<Product> products) throws ListOverflowException {
        products.insert(new Product("Notebook", 199, 1));
        products.insert(new Product("Pencil Set", 299, 2));
        products.insert(new Product("Highlighter", 99, 3));
        products.insert(new Product("Eraser", 49, 4));
        products.insert(new Product("Backpack", 2499, 5));
        products.insert(new Product("Ruler", 149, 6));
        products.insert(new Product("Markers", 399, 7));
        products.insert(new Product("Crayons", 199, 8));
        products.insert(new Product("Calculator", 599, 9));
        products.insert(new Product("Scissors", 249, 10));
        products.insert(new Product("Glue Stick", 79, 11));
        products.insert(new Product("Lunchbox", 799, 12));
        products.insert(new Product("Water Bottle", 299, 13));
        products.insert(new Product("Protractor", 199, 14));
        products.insert(new Product("Geometry Set", 499, 15));
        products.insert(new Product("Colored Pencils", 349, 16));
        products.insert(new Product("Notebook Paper", 149, 17));
        products.insert(new Product("Stapler", 399, 18));
        products.insert(new Product("Whiteboard", 899, 19));
        products.insert(new Product("Markers", 299, 20));
    }


    /**
     * Main method for the shopping application.
     *
     * @param args The command-line arguments (not used).
     * @throws ListOverflowException If the list overflows.
     */
    public static void main(String[] args) throws ListOverflowException {

        //populate the list
        initializeProducts(products);

        boolean running = true;

        while(running) {

            System.out.println();
            System.out.println();
            showMenuItems();

            switch (getChoice(">> ", 1, !cartItems.isEmpty() ? 4 : 3)) {
                case 1 -> {
                    Product newProduct = getItem();

                    if(newProduct == null) {
                        System.out.println("\t\t\tInvalid ID");
                        break;
                    }

                    addItemToCart(newProduct);
                    System.out.println("\n\n\t\t"+newProduct.getProductName()+ " is added successfully to your cart!");
                }
                case 2 -> {
                    displayCartItems();
                    System.out.print("\t\t\tEnter Any Key to Continue...");
                    sc.next();
                }
                case 3 -> {

                    if(cartItems.isEmpty()) { //exit, option 3 is hidden on the screen
                        running = false;
                        break;
                    }

                    displayCartItems();
                    System.out.println();
                    int itemId = getChoice("Item ID: ", 1, Integer.MAX_VALUE); // get the ID of the product

                    Product deletedProduct = null;

                    // find if the product id is available on the cart
                    for(int i = 0; i < cartItems.getSize();i++) {
                        if(cartItems.getAtIndex(i).getProductId() == itemId) {
                            deletedProduct = cartItems.getAtIndex(i);
                            break;
                        }
                    }

                    // product is found
                    if(deletedProduct != null) {
                        deleteItemOnCart(deletedProduct);
                        System.out.println("\t\t\t"+deletedProduct.getProductName()+ " is successfully removed!");
                    }else {
                        System.out.println("\t\t\tInvalid ID");
                    }
                }
                case 4 -> running = false;
            }

        }


    }

    /**
     * Get a choice from the user within a specified range.
     *
     * @param message The message to display.
     * @param min The minimum valid choice.
     * @param max The maximum valid choice.
     * @return The user's choice.
     */
    private static int getChoice(String message, int min, int max) {

        int choice;

        do {

            try {
                System.out.print("\t\t\t"+message);
                choice = sc.nextInt();

                if(choice > max || choice < min) {
                    System.out.println("\t\tPlease enter a valid option");
                }

            }catch (InputMismatchException e) {
                System.out.println("\t\tPlease enter a valid integer number");
                sc.next();
                choice = -1; // will make the loop to run again if there is an error
            }

        }while(choice > max || choice < min || choice == -1);

        return choice;
    }

    /**
     * Show the list of available products.
     */
    private static void showProducts() {

        System.out.println("\t\tProduct Lists\n");
        for(int i = 0; i < products.getSize() ; i++) {
            System.out.println(products.getAtIndex(i).toString());
        }
    }

    /**
     * Display the items in the shopping cart.
     */
    private static void displayCartItems() {
        if (cartItems.isEmpty()) {
            System.out.println("\t\t\tYour cart is currently empty");
        } else {
            System.out.println("\n\n\t\tYour cart items\n");
            for (int i = 0; i < cartItems.getSize(); i++) {
                Product cartProduct = cartItems.getAtIndex(i);
                System.out.println("\t\t\t\tProduct Name: " + cartProduct.getProductName());
                System.out.println("\t\t\t\tQuantity: " + cartProduct.getQuantity());

                int totalPriceCents = cartProduct.getPriceCents() * cartProduct.getQuantity();
                String formattedPrice = formatCurrency(totalPriceCents);

                System.out.println("\t\t\t\tPrice: $" + formattedPrice);
                System.out.println("\t\t\t\tID: " + cartProduct.getProductId());
                System.out.println("\t\t\t\t----------");
            }
        }
    }

    private static String formatCurrency(int totalPriceCents) {
        int dollars = totalPriceCents / 100;
        int cents = totalPriceCents % 100;

        // Format dollars and cents as a currency string
        return "$" + dollars + "." + (cents < 10 ? "0" : "") + cents;
    }


    /**
     * Show the available menu items.
     */
    private static void showMenuItems() {

        System.out.println("\t\t1. Add Item to cart");

        //display the option to delete a cart item only if there is an item on the cart
        if(cartItems.isEmpty()) {
            System.out.println("\t\t2. Show Cart (Empty Cart)");
            System.out.println("\t\t3. Exit Application");
        }else {
            System.out.println("\t\t2. Show Cart ("+cartItems.getSize()+")");
            System.out.println("\t\t3. Delete an Item on Cart");
            System.out.println("\t\t4. Exit Application");
        }
    }

    /**
     * Add an item to the shopping cart.
     *
     * If the product exist on the cart already, the quantity will be updated
     *
     * @param product The product to add.
     * @throws ListOverflowException If there's an issue with the cart list.
     */
    private static void addItemToCart(Product product) throws ListOverflowException {

        Product updatedCartItem = null;

        //check if the product is already on the cart
        for(int i = 0; i < cartItems.getSize(); i++) {

            //if the item is present on the cart
            if(product.getProductId() == cartItems.getAtIndex(i).getProductId()) {
                updatedCartItem = cartItems.getAtIndex(i); // make this the new product on the cart
                updatedCartItem.setQuantity(product.getQuantity() + updatedCartItem.getQuantity()); // update the quantity
                cartItems.delete(product); // delete the old product present on the cart
                break;
            }
        }

        // if item is not present on the cart, add the passed product parameter, else add the updatedCartItem
        cartItems.insert(updatedCartItem == null ? product : updatedCartItem);
    }

    /**
     * Get an item from the list of available products.
     *
     * @return The selected product.
     */
    private static Product getItem() {

        System.out.println("\n\n");
        showProducts();
        Product newProduct = null;

        int choice = getChoice("Item ID: ", 1, Integer.MAX_VALUE);

        //checks if the ID is available
        for(int i = 0; i < products.getSize(); i++) {

            if(products.getAtIndex(i).getProductId() == choice) {
                newProduct = products.getAtIndex(i);
                break;
            }

        }

        if(newProduct == null) {
            return null;
        }

        int quantity = getChoice("Quantity (from 1-10 only): ", 1, 10);
        newProduct.setQuantity(quantity);
        return newProduct;
    }

    /**
     * Delete an item from the shopping cart.
     *
     * @param product The product to delete.
     */
    private static void deleteItemOnCart(Product product) {
        cartItems.delete(product);
    }
}

