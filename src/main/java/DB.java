import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    private PreparedStatement preparedStatement;
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;
    private String query;

    public DB() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://den1.mysql4.gear.host:3306/thomasdatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "thomasdatabase", "Uw3LL8C-~yiV");
    }

    public void createProduct(Product product) throws SQLException {
        query = "INSERT INTO products (`product_name`, `product_price`, `product_location`) values(?, ?, ?)";
        createStatement(product, query);
    }

    public void updateProduct(Product product) throws SQLException {
        query = "UPDATE TABLE products SET (`product_name`, `product_price`, `product_location`) values(?, ?, ?) WHERE `id`=" + product.getId() + "";
        createStatement(product, query);
    }

    public List<Product> getProducts() throws SQLException {
        query = "SELECT * FROM products";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        List<Product> productList = new ArrayList();
        while (resultSet.next()) {
            Product product = new Product(resultSet.getInt("id"), resultSet.getString("product_name"),
            resultSet.getInt("product_price"), resultSet.getString("product_location"));
            productList.add(product);
        }
        return productList;
    }

    public void deleteProduct(Product product) {

    }

    public void createStatement(Product product, String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setString(3, product.getLocation());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }



}
