package prelim.Util;

/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 *
 * Algorithm: Property Class
 *
 * Class Definition:
 *
 * Create a class named Property.
 * Instance Variables:
 *
 * Define instance variables:
 * model (String)
 * color (String)
 * status (String)
 * Constructor:
 *
 * Create a constructor for the Property class that takes a single argument:
 * Input: details (String)
 * Split the details string using a comma , as the delimiter.
 * If the split results in exactly three parts:
 * Assign the first part to the model attribute after trimming leading and trailing whitespaces.
 * Assign the second part to the color attribute after trimming leading and trailing whitespaces.
 * Assign the third part to the status attribute after trimming leading and trailing whitespaces.
 * If the split does not result in exactly three parts:
 * Throw an IllegalArgumentException with the message "Invalid property details: [details]" where [details] is the input string.
 * toString Method:
 *
 * Create a toString method to return a string representation of the Property object.
 * Output:
 * Return a string containing the following information:
 * "Model: [model] Color: [color] Status: [status]" where [model], [color], and [status] are the values of the respective attributes.
 * Getter Methods:
 *
 * Create getter methods for the model, color, and status attributes.
 * Define methods:
 * getModel(): Returns the model attribute.
 * getColor(): Returns the color attribute.
 * getStatus(): Returns the status attribute.
 * End of Class:
 *
 * End the class definition.
 */
public class Property {
    private String model;
    private String color;
    private String status;

    /**
     * Constructor to initialize a prelim.Util.Property object with details.
     *
     * @param details A string containing property details in the format: model, color, status.
     * @throws IllegalArgumentException If the input format is invalid.
     */
    public Property(String details) throws IllegalArgumentException {
        String[] parts = details.split(",");
        if (parts.length == 3) {
            model = parts[0].trim();
            color = parts[1].trim();
            status = parts[2].trim();
        } else {
            throw new IllegalArgumentException("Invalid property details: " + details);
        }
    }

    /**
     * Returns a string representation of the prelim.Util.Property.
     */
    @Override
    public String toString() {
        return "Model: " + model + " Color: " + color + " Status: " + status;
    }

    /**
     * Get the model of the property.
     *
     * @return The model attribute.
     */
    public String getModel() {
        return model;
    }

    /**
     * Get the color of the property.
     *
     * @return The color attribute.
     */
    public String getColor() {
        return color;
    }

    /**
     * Get the status of the property.
     *
     * @return The status attribute.
     */
    public String getStatus() {
        return status;
    }
}
