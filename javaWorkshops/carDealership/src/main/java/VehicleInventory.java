import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {

    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleInventory() {
        vehicles.add(new Vehicle("1HGCM82633A004352", 2021, "HONDA", "CIVIC", "SEDAN", "SILVER", 28500, 19400));
        vehicles.add(new Vehicle("2FMPK4J92MBA12345", 2022, "FORD", "EDGE", "SUV", "RED", 14200, 31750));
        vehicles.add(new Vehicle("2FMPK4J92MBA12345", 2022, "FORD", "EDGE", "SUV", "RED", 14200, 31750));
        vehicles.add(new Vehicle("5YJSA1E26FF123456", 2019, "TESLA", "MODEL S", "ELECTRIC SEDAN", "BLUE", 39000, 520000));
        vehicles.add(new Vehicle("1FTFW1ET5EKE12345", 2020, "FORD", "F-150", "PICKUP", "WHITE", 61000, 29500));
        vehicles.add(new Vehicle("1HGCM82633A004852", 2021, "HONDA", "CIVIC", "SEDAN", "SILVER", 28501, 19400));
        vehicles.add(new Vehicle("2FMPK4J92MBA12545", 2022, "FORD", "EDGE", "SUV", "RED", 14220, 31750));
        vehicles.add(new Vehicle("WBA3A5C56CF123156", 2015, "BMW", "328i", "SEDAN", "WHITE", 67300, 13900));
        vehicles.add(new Vehicle("5YJSA1E26FF123356", 2019, "TESLA", "MODEL S", "ELECTRIC SEDAN", "BLUE", 39300, 520000));
        vehicles.add(new Vehicle("1FTFW1ET5EKE10341", 2020, "FORD", "F-150", "PICKUP", "WHITE", 61060, 29500));
        vehicles.add(new Vehicle("1HGCM82633A004351", 2021, "HONDA", "CIVIC", "SEDAN", "SILVER", 8500, 19400));
        vehicles.add(new Vehicle("2FMPK4J92MBA12341", 2022, "FORD", "EDGE", "SUV", "RED", 4200, 61750));
        vehicles.add(new Vehicle("WBA3A5C56CF123451", 2015, "BMW", "328i", "SEDAN", "WHITE", 7300, 63900));
        vehicles.add(new Vehicle("5YJSA1E26FF123451", 2019, "TESLA", "MODEL S", "ELECTRIC SEDAN", "BLUE", 9000, 52000));
        vehicles.add(new Vehicle("1FTFW1ET5EKE12341", 2020, "FORD", "F-150", "PICKUP", "WHITE", 1000, 69500));
        vehicles.add(new Vehicle("1FTFW1ET5EKE12541", 2020, "FORD", "F-150", "PICKUP", "WHITE", 1000, 69500));
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
