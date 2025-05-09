import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner input = new Scanner(System.in);

    public static void displayMainMenu() {
        boolean run = true;
        while (run) {
            String menu = """
                            WELCOME TO [ADD YOUR DEALERSHIP NAME HERE]!
                                    WHAT CAN WE DO FOR YOU TODAY?
                    ===========================================================
                    PLEASE SELECT ONE OF THE FOLLOWING OPTIONS:
                    
                    1 - FIND VEHICLES WITHIN A PRICE RANGE
                    
                    2 - FIND VEHICLES BY MAKE / MODEL
                    
                    3 - FIND VEHICLES BY YEAR RANGE
                    
                    4 - FIND VEHICLES BY COLOR
                    
                    5 - FIND VEHICLES BY MILEAGE RANGE
                    
                    6 - FIND VEHICLES BY TYPE (CAR, TRUCK, SUV, VAN)
                    
                    7 - LIST ALL VEHICLES
                    
                    8 - ADD A VEHICLE
                    
                    9 - REMOVE A VEHICLE
                    
                    99 - QUIT
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
                    System.out.println("===========================================================\n\nTHANK YOU FOR WORKING WITH [ADD YOUR DEALERSHIP NAME HERE]!\n\nHAVE A GREAT DAY!");
                    run = false;
                    break;
            }
        }
    }
}
