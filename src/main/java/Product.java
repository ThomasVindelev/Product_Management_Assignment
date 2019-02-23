import java.sql.SQLException;
import java.util.Scanner;

public class Product {

    private int id;
    private String name;
    private int price;
    private String location;

    public Product(String name, int price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public Product(int id, String name, int price, String location) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public Product() {

    }

    public Product productConsole(Scanner scanner) {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Price: ");
        String price = scanner.nextLine();
        System.out.println("Location: ");
        String location = scanner.nextLine();
        Product product = new Product(name, Integer.parseInt(price), location);
        return product;
    }

    public void read(DB db) throws SQLException {
        for (Product product : db.getProducts()) {
            System.out.println("ID: " + product.getId() + "\nName: " + product.getName() + "\nPrice: " + product.getPrice() + "\nLocation: " + product.getLocation());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
