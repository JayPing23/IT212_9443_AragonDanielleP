/**
 * Name: Aragon, Danielle John P.
 * Date: September 09, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: Product Class
 *
 * Class Definition
 *
 * Create a class named Product.
 * Instance Variables
 *
 * Define the following private instance variables within the class:
 * productId (integer): Represents the unique identifier of the product.
 * productName (string): Represents the name of the product.
 * priceCents (integer): Represents the price of the product in cents.
 * quantity (integer): Represents the quantity of the product (initialized to 0).
 * Constructor
 *
 * Define a constructor method with the following signature:
 * public Product(String productName, int priceCents, int productId)
 * Parameters:
 * productName: The name of the product (string).
 * priceCents: The price of the product in cents (integer).
 * productId: The unique identifier of the product (integer).
 * Purpose: This constructor is used to create a new Product object with the specified product name, price in cents, and product ID.
 * Getter Methods
 *
 * Define the following getter methods to access the instance variables:
 * getProductId(): int: Returns the product's unique identifier.
 * getProductName(): String: Returns the product's name.
 * getPriceCents(): int: Returns the product's price in cents.
 * getQuantity(): int: Returns the quantity of the product.
 * Setter Method
 *
 * Define a setter method with the following signature:
 * setQuantity(int quantity)
 * Parameters:
 * quantity: The new quantity of the product (integer).
 * Purpose: This method is used to set the quantity of the product.
 * Method toString
 *
 * Define a toString method with the following signature:
 * @Override public String toString()
 * Purpose: This method generates a string representation of the Product object, including its product ID, name, and formatted price.
 * Return Value: A string representing the product information.
 * Private Method formatCurrency
 *
 * Define a private helper method with the following signature:
 * private String formatCurrency(int priceCents)
 * Parameters:
 * priceCents: The price of the product in cents (integer).
 * Purpose: This method converts the price in cents to a formatted currency string (e.g., "$10.99").
 * Return Value: A string representing the formatted currency.
 */
package prelim.Util;
import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    // Instance Variables
    private int productId;
    private String productName;
    private int priceCents;
    private int quantity;

    /**
     * Constructor to create a Product object with specified attributes.
     *
     * @param productName The name of the product (string).
     * @param priceCents The price of the product in cents (integer).
     * @param productId The unique identifier of the product (integer).
     */
    public Product(String productName, int priceCents, int productId) {
        this.productId = productId;
        this.productName = productName;
        this.priceCents = priceCents;
        this.quantity = 0; // Initialize quantity to 0
    }

    /**
     * Getter method to retrieve the product's unique identifier.
     *
     * @return The product's unique identifier (integer).
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Getter method to retrieve the product's name.
     *
     * @return The product's name (string).
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Getter method to retrieve the product's price in cents.
     *
     * @return The product's price in cents (integer).
     */
    public int getPriceCents() {
        return priceCents;
    }

    /**
     * Getter method to retrieve the quantity of the product.
     *
     * @return The quantity of the product (integer).
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter method to set the quantity of the product.
     *
     * @param quantity The new quantity of the product (integer).
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Generates a string representation of the Product object.
     *
     * @return A string representing the product information.
     */
    @Override
    public String toString() {
        return "Product ID: " + productId +
                "\nProduct Name: " + productName +
                "\nPrice: " + formatCurrency(priceCents) +
                "\n----------";
    }

    /**
     * Private helper method to format the price in cents as a currency string.
     *
     * @param priceCents The price of the product in cents (integer).
     * @return A string representing the formatted currency.
     */
    private String formatCurrency(int priceCents) {
        // Format priceCents as a currency string (e.g., "$10.99")
        double priceInDollars = priceCents / 100.0;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormatter.format(priceInDollars);
    }
}