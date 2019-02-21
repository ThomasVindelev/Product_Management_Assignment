import java.util.Scanner;

public class Menu {



    public void start() {
        System.out.println("Welcome to my-KEA.");
        System.out.print("1. Create product" + "\n2. Update product" +
                         "\n3. Delete product" + "\n4. Get products" + "\nType /quit to exit");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();

        switch (choice) {
            case "1":

                break;

        }

    }

}
