import java.sql.SQLException;

public class ProductInventory {
    private int id;
    private int productId;
    private String locationId;
    private int quantity;

    public ProductInventory(int id, int productId, String locationId, int quantity) throws SQLException {
        this.id = id;
        this.productId = productId;
        this.locationId = locationId;
        this.quantity = quantity;
    }
}
