import java.sql.SQLException;
import java.util.Scanner;

public class Product {

    private int id;
    private String name;
    private int price;
    private String location;
    private DB db = new DB();

    public Product(int id, String name, int price, String location) throws SQLException {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public Product() throws SQLException {

    }

    public void productConsole(Scanner scanner, String choice) throws SQLException {
        int id = 0;
        Scanner idScanner = new Scanner(System.in);
        if (choice.equals("1") || choice.equals("2")) {
            if (choice.equals("2")) {
                System.out.println("Choose product to update by ID:");
                id = idScanner.nextInt();
                if (!db.verifyProduct(id)) {
                    System.out.println("Not a valid ID");
                    return;
                }
            }
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Price: ");
            String price = scanner.nextLine();
            System.out.println("Location: ");
            String location = scanner.nextLine();
            Product product = new Product(id, name, Integer.parseInt(price), location);
            if (choice.equals("1")) {
                db.createProduct(product);
            } else {
                db.updateProduct(product);
            }
        } else {
            System.out.println("Choose product to delete by ID:");
            Product product = new Product();
            product.setId(idScanner);
            if (!db.verifyProduct(product.getId())) {
                System.out.println("Not a valid ID");
                return;
            }
            db.deleteProduct(product);
        }
    }

    public void read() throws SQLException {
        System.out.println();
        for (Product product : db.getProducts()) {
            System.out.println("ID: " + product.getId() + "\nName: " + product.getName() + "\nPrice: " + product.getPrice() + "\nLocation: " + product.getLocation() + "\n");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(Scanner scanner) {
        this.id = scanner.nextInt();
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