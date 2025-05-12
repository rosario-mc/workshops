import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner input = new Scanner(System.in);
    Dealership dealership = new Dealership();

    public void displayMainMenu() {
        boolean run = true;
        UserInterface ui = new UserInterface();
        ui.init();

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
                6 - FIND VEHICLES BY TYPE (CAR, TRUCK, SUV, VAN, ELECTRIC)
                7 - LIST ALL VEHICLES
                8 - ADD A VEHICLE
                9 - REMOVE A VEHICLE
                99 - QUIT
                """;
            System.out.println(menu);
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "1", "PRICE RANGE":
                    Dealership.getVehicleByPrice("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "2", "MAKE/MODEL":
                    Dealership.getVehicleByMakeModel("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "3", "YEAR RANGE":
                    Dealership.getVehicleByYear("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "4", "COLOR":
                    Dealership.getVehicleByColor("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "5", "MILEAGE RANGE":
                    Dealership.getVehicleByMileage("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "6", "TYPE":
                    Dealership.getVehicleByType("carDealership/src/main/resources/VehicleInventoryList.csv");
                    break;
                case "7":
                   processAllVehiclesRequest();
                    break;
                case "8":
                    addVehicle();
                    break;
                case "9":
                    removeVehicle();
                    break;
                case "99", "QUIT":
                    System.out.println("THANK YOU FOR WORKING WITH [ADD YOUR DEALERSHIP NAME HERE]!");
                    run = false;
                    break;
                default:
                    System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
            }
        }
    }

    private void addVehicle() {
        System.out.println("=== ADD A NEW VEHICLE ===");

        System.out.print("ENTER VIN: ");
        String vin = input.nextLine().trim();

        System.out.print("ENTER YEAR: ");
        int year = Integer.parseInt(input.nextLine().trim());

        System.out.print("ENTER MAKE: ");
        String make = input.nextLine().trim();

        System.out.print("ENTER MODEL: ");
        String model = input.nextLine().trim();

        System.out.print("ENTER TYPE (E.G., CAR, TRUCK, SUV): ");
        String type = input.nextLine().trim();

        System.out.print("ENTER COLOR: ");
        String color = input.nextLine().trim();

        System.out.print("ENTER ODOMETER READING: ");
        int odometer = Integer.parseInt(input.nextLine().trim());

        System.out.print("ENTER PRICE: ");
        double price = Double.parseDouble(input.nextLine().trim());

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);

        DealershipFileManager dfm = new DealershipFileManager();
        dfm.appendVehicle(newVehicle, "carDealership/src/main/resources/VehicleInventoryList.csv");

        System.out.println("VEHICLE ADDED AND SAVED SUCCESSFULLY!\n");
    }

    private void removeVehicle() {
        System.out.println("=== REMOVE A VEHICLE ===");

        init();

        System.out.print("ENTER VIN OF VEHICLE TO REMOVE: ");
        String vin = input.nextLine().trim();

        boolean removed = dealership.removeVehicle(vin);

        if (removed) {
            DealershipFileManager dfm = new DealershipFileManager();
            dfm.saveDealership(dealership, "carDealership/src/main/resources/VehicleInventoryList.csv"); // rewrites full list
            System.out.println("Vehicle removed and changes saved.\n");
        } else {
            System.out.println("Vehicle with VIN '" + vin + "' not found.\n");
        }
    }

    private void init() {
        try {
            dealership = DealershipFileManager.getDealership("carDealership/src/main/resources/VehicleInventoryList.csv");
        } catch (IOException e) {
            System.out.println("Failed to load dealership data: " + e.getMessage());
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("NO VEHICLES FOUND.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    private void processAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }
}