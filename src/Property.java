/**
 * Name: Aragon, Danielle John P.
 * Date: September 20, 2023
 * 9443-IT212/IT212L-SAMCIS-CIS
 */
public class Property {
    private String model;
    private String color;
    private String status;

    /**
     * Constructor to initialize a Property object with details.
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
     * Returns a string representation of the Property.
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
