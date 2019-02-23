import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void start() throws SQLException {

        Product product = new Product();
        DB db = new DB();

        System.out.println("Welcome to my-KEA.");
        System.out.print("1. Create product" + "\n2. Update product" +
                         "\n3. Delete product" + "\n4. Get products" + "\nType /quit to exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                product = product.productConsole(scanner);
                db.createProduct(product);
                break;
            case "2":
                product.read(db);

        }

    }

}
