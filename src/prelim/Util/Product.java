package prelim.Util;
import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    private int productId;
    private String productName;
    private int priceCents;
    private int quantity;

    public Product(String productName, int priceCents, int productId) {
        this.productId = productId;
        this.productName = productName;
        this.priceCents = priceCents;
        this.quantity = 0; // Initialize quantity to 0
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPriceCents() {
        return priceCents;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                "\nProduct Name: " + productName +
                "\nPrice: " + formatCurrency(priceCents) +
                "\n----------";
    }

    private String formatCurrency(int priceCents) {
        // Format priceCents as a currency string (e.g., "$10.99")
        double priceInDollars = priceCents / 100.0;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormatter.format(priceInDollars);
    }
}
