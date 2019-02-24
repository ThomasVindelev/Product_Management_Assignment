import java.sql.SQLException;
import java.util.Scanner;

public class Product {

    private int id;
    private String type;
    private String name;
    private int price;
    private String location;
    private Location productLocation = new Location();
    private DB db = new DB();
    private ProductType productType = new ProductType();

    public Product(int id, String type, String name, int price, String location) throws SQLException {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public Product() throws SQLException {

    }

    public void productConsole(Scanner scanner, String choice) throws SQLException {
        id = 0;
        Scanner idScanner = new Scanner(System.in);
        if (choice.equals("1") || choice.equals("2")) {
            if (choice.equals("2")) {
                System.out.println("Choose product to update by ID:");
                id = idScanner.nextInt();
                if (!db.verifyProduct(id)) {
                    System.out.println("Not a valid ID.");
                    return;
                }
            }
            productType.printProductTypes();
            type = scanner.nextLine();
            System.out.print("\nName: ");
            name = scanner.nextLine();
            System.out.print("Price: ");
            String price = scanner.nextLine();
            productLocation.printProductLocations ();
            location = scanner.nextLine();
            Product product = new Product(id, type, name, Integer.parseInt(price), location);
            if (choice.equals("1")) {
                db.createProduct(product);
                System.out.println("\nProduct created!\n");
            } else {
                db.updateProduct(product);
                System.out.println("\nProduct updated!\n");
            }
        } else {
            System.out.println("Choose product to delete by ID:");
            Product product = new Product();
            product.setId(idScanner);
            if (!db.verifyProduct(product.getId())) {
                System.out.println("Not a valid ID.");
                return;
            }
            db.deleteProduct(product);
            System.out.println("\nProduct deleted!\n");
        }
    }

    public void read() throws SQLException {
        System.out.println();
        for (Product product : db.getProducts()) {
            System.out.println("ID: " + product.getId() + "\nType: " + product.getType() + "\nName: " + product.getName() + "\nPrice: " + product.getPrice() + "\nLocation: " + product.getLocation() + "\n");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(Scanner scanner) {
        this.id = scanner.nextInt();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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