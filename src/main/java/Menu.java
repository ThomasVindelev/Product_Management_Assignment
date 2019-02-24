import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void start() throws SQLException {

        Product product =   new Product();
        Scanner scanner =   new Scanner(System.in);
        boolean isOver =    false;

        System.out.println("Welcome to my-KEA!");

        while (!isOver) {
            System.out.println("1. Create product" + "\n2. Update product" +
                    "\n3. Delete product" + "\n4. Get products" + "\nType /quit to exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    product.productConsole(scanner, choice);
                    break;
                case "2":
                    product.read();
                    product.productConsole(scanner, choice);
                    break;
                case "3":
                    product.read();
                    product.productConsole(scanner, choice);
                    break;
                case "4":
                    product.read();
                    break;
                case "/quit":
                    isOver = true;
                    break;
                default:
                    System.out.println("Not a valid input.\n");
                    break;
            }
        }
    }
}