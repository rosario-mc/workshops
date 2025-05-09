import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner input = new Scanner(System.in);

    public static void displayMainMenu() {
        boolean run = true;
        while (run) {
            String menu = """
                            Welcome To [ADD YOUR DEALERSHIP NAME HERE]!
                                    What Can We Do For You Today?
                    ===========================================================
                    Please select one of the following options:
                    
                    1 - Find vehicles within a price range
                    
                    2 - Find vehicles by make / model
                    
                    3 - Find vehicles by year range
                    
                    4 - Find vehicles by color
                    
                    5 - Find vehicles by mileage range
                    
                    6 - Find vehicles by type (car, truck, SUV, van)
                    
                    7 - List ALL vehicles
                    
                    8 - Add a vehicle
                    
                    9 - Remove a vehicle
                    
                    99 - Quit
                    """;
            System.out.println(menu);
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "1", "FIND VEHICLES WITHIN A PRICE RANGE", "VEHICLES WITHIN A PRICE RANGE", "WITHIN A PRICE RANGE",
                     "PRICE RANGE", "PRICE":
                    Dealership.getVehicleByPrice("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "2", "FIND VEHICLES BY MAKE/MODEL", "VEHICLES BY MAKE/MODEL", "MAKE/MODEL":
                    Dealership.getVehicleByMakeModel("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "3", "FIND VEHICLES BY YEAR RANGE", "VEHICLES BY YEAR RANGE", "YEAR RANGE":
                    Dealership.getVehicleByYear("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "4", "FIND VEHICLES BY COLOR", "VEHICLES BY COLOR", "COLOR":
                    Dealership.getVehicleByColor("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "5", "FIND VEHICLES BY MILAGE RANGE", "VEHICLES BY MILAGE RANGE", "MILAGE RANGE":
                    Dealership.getVehicleByMileage("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "6", "FIND VEHICLES BY TYPE (CAR, TRUCK, SUV, VAN)", "VEHICLES BY TYPE (CAR, TRUCK, SUV, VAN)",
                     "TYPE (CAR, TRUCK, SUV, VAN)", "TYPE":
                    Dealership.getVehicleByType("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "7", "LIST ALL VEHICLES", "ALL VEHICLES", "ALL":
                    Dealership.getAllVehicles("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "8", "ADD A VEHICLE", "ADD":
                    break;
                case "9", "REMOVE A VEHICLE", "REMOVE":
                    break;
                case "99", "QUIT", "EXIT", "BYE", "GOODBYE", "GOOD BYE":
                    System.out.println("===========================================================\n\nThank you for working with [ADD YOUR DEALERSHIP NAME HERE]!\n\nHave a great day!");
                    run = false;
                    break;
            }
        }
    }
}
