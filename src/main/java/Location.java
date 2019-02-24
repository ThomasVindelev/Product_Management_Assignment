import java.sql.SQLException;

public class Location {

    private int id;
    private String name;
    private String address;
    private DB db = new DB();

    public Location(int id,String name,String address) throws SQLException {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Location() throws SQLException {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void printProductLocations() throws SQLException {
        System.out.println("Select product locations:\n");
        for (Location location : db.getProductLocations()) {
            System.out.print("ID:" + location.getId() + " " + location.getName() + " " + location.getAddress() + " \n");
        }
    }
}