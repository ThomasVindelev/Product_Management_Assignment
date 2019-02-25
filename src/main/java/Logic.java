import java.sql.SQLException;
import java.util.Scanner;

public class Logic {

    private Location productLocation =  new Location();
    private DB db =                     new DB();
    private ProductType productType =   new ProductType();

    public Logic() throws SQLException {
    }

    public void prompt(Scanner scanner, String choice) throws SQLException {
        int id = 0;
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
            String type = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            String price = scanner.nextLine();
            productLocation.printProductLocations ();
            String location = scanner.nextLine();
            System.out.print("Quantity: ");
            int quantity = idScanner.nextInt();
            Product product = new Product(id, type, name, Integer.parseInt(price), location);

            if (choice.equals("1")) {
                db.createProduct(product);
                db.addProductToInventory(location, quantity);
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

}
