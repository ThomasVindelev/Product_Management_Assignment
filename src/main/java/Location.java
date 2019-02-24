public class Location {

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
}