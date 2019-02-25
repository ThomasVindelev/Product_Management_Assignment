import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void start() throws SQLException {

        Logic logic = new Logic();
        Scanner scanner =   new Scanner(System.in);
        boolean isOver =    false;

        System.out.println("Welcome to my-KEA!");

        while (!isOver) {
            System.out.println("1. Create product" + "\n2. Update product" +
                    "\n3. Delete product" + "\n4. Get products" + "\nType /quit to exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    logic.prompt(scanner, choice);
                    break;
                case "2":
                    logic.read();
                    logic.prompt(scanner, choice);
                    break;
                case "3":
                    logic.read();
                    logic.prompt(scanner, choice);
                    break;
                case "4":
                    logic.read();
                    break;
                case "/quit":
                    isOver = true;
                    break;
                default:

                    break;
            }
        }
    }
}