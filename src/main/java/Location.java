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



    public String setLocation(String type) {
        String location = "";
        switch (type) {
            case "1":
                location = "1";
                break;
            case "2":
                location = "2";
                break;
            case "3":
                location = "3";
                break;
            case "4":
                location = "4";
                break;
            case "5":
                location = "5";
                break;
            case "6":
                location = "6";
                break;
            case "7":
                location = "7";
                break;
            case "8":
                location = "8";
                break;
            default:
                System.out.println("Not a valid choice.");
        }
        return location;
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