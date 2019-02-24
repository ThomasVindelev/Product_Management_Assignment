import java.sql.SQLException;
import java.util.Scanner;

public class ProductType {

    private int id;
    private String productType;
    private DB db = new DB();

    public ProductType(int id,String productType) throws SQLException {
        this.id = id;
        this.productType = productType;
    }

    public ProductType() throws SQLException {

    }

    public int getId() {
        return id;
    }

    public void setId(Scanner scanner) {
        this.id = scanner.nextInt();
    }

    public String getProductType() {
        return productType;
    }

    public void setproductType(String productType) {
        this.productType = productType;

    }

    public void printProductTypes() throws SQLException {
        System.out.println("Select product type:\n");
        for (ProductType productType : db.getProductTypes()) {
            System.out.print("ID:" + productType.getId() + " " + productType.getProductType() + "\n");
        }
    }
}