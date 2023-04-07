/**
 * Product class
 */

public class Product {
    String code;
    String title;
    int quantity;
    double price;

    /**
     * Default constructor
     */

    public Product() {

    }


    /**
     * Constructor method to initialize a product
     *
     * @param code    Product's bar code
     * @param title    Product's title
     * @param quantity Product's quantity
     * @param price    Product's price
     */

    public Product(String code, String title, int quantity, double price) {
        this.code = code;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Convert this product to String for printing
     */

    @Override
    public String toString() {
        return String.format("%-5s%-5s%-15s%-5s%-7.1s%-5s%s",  this.code,  "|",  this.title, "|",  this.quantity,  "|",  this.price);
//        return "" + this.code + " | " + this.title +" | " + this.quantity + " | " + this.price;
    }
}


