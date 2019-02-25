import java.sql.SQLException;
import java.util.Scanner;

public class Product {

    private int     id;
    private String  type;
    private String  name;
    private int     price;
    private String  location;
    private int     quantity;

    public Product(int id, String type, String name, int price, String location) throws SQLException {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public Product() throws SQLException {

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