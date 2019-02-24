import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private String query;

    public DB() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/products?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "");
    }

    public void createProduct(Product product) throws SQLException {
        query = "INSERT INTO products (`product_name`, `product_price`, `product_location`) values(?, ?, ?)";
        executeStatement(product, query);
    }

    public void updateProduct(Product product) throws SQLException {
        query = "UPDATE products SET `product_name`=?, `product_price`=?, `product_location`=? WHERE `id`=" + product.getId() + "";
        executeStatement(product, query);
    }

    public List<Product> getProducts() throws SQLException {
        query = "SELECT * FROM products";
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        List<Product> productList = new ArrayList();
        while (resultSet.next()) {
            Product product = new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("product_name"),
                    resultSet.getInt("product_price"),
                    resultSet.getString("product_location"));
            productList.add(product);
        }
        return productList;
    }

    public void deleteProduct(Product product) throws SQLException {
        query = "DELETE FROM products WHERE `id`=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, product.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void executeStatement(Product product, String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setString(3, product.getLocation());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public boolean verifyProduct(int id) throws SQLException {
        query = "SELECT * FROM products WHERE id=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}