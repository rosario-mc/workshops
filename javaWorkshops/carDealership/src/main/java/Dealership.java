import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> vehicles;

    public Dealership() {
        this.vehicles = new ArrayList<>();
    }

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void getVehicleByPrice(String filename) {
        DealershipFileManager.printVehicleListInRange(filename, 7);
    }

    public static void getVehicleByMakeModel(String filename) {
        DealershipFileManager.printVehicleListByFilter(filename);
    }

    public static void getVehicleByYear(String filename) {
        DealershipFileManager.printVehicleListInRange(filename, 1);
    }

    public static void getVehicleByColor(String filename) {
        DealershipFileManager.printVehicleListByFilter(filename);
    }

    public static void getVehicleByMileage(String filename) {
        DealershipFileManager.printVehicleListInRange(filename, 6);
    }

    public static void getVehicleByType(String filename) {
        DealershipFileManager.printVehicleListByFilter(filename);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(v -> v.getVin().equalsIgnoreCase(vin));
    }


}
