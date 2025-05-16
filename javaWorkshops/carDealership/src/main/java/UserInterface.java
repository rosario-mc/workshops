import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner input = new Scanner(System.in);
    Dealership dealership = new Dealership();

    public void displayMainMenu() {
        boolean run = true;
        init();

        while (run) {
            String menu = """
                                      WELCOME!
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
                10- SELL/LEASE A VEHICLE
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
                case "7", "LIST ALL":
                   processAllVehiclesRequest();
                    break;
                case "8", "ADD":
                    addVehicle();
                    break;
                case "9", "REMOVE":
                    removeVehicle();
                    break;
                case "10", "SELL", "LEASE":
                    sellLeaseVehicle();
                    break;
                case "99", "QUIT":
                    System.out.println("THANK YOU!\nHAVE A GREAT DAY:)\nclosing program....");
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

        System.out.print("ENTER TYPE (e.g., CAR, TRUCK, SUV): ");
        String type = input.nextLine().trim();

        System.out.print("ENTER COLOR: ");
        String color = input.nextLine().trim();

        System.out.print("ENTER ODOMETER: ");
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

    private void sellLeaseVehicle(){
        System.out.print("ENTER VIN OF VEHICLE TO SELL OR LEASE: ");
        String vin = input.nextLine().trim();

        Vehicle vehicle = dealership.getVehicleByVin(vin);
        if (vehicle == null) {
            System.out.println("VEHICLE NOT FOUND.");
            return;
        }

        System.out.print("ENTER CUSTOMER NAME: ");
        String customerName = input.nextLine().trim();

        System.out.print("ENTER CUSTOMER EMAIL: ");
        String customerEmail = input.nextLine().trim();

        System.out.print("IS THIS A SALE OR LEASE? ");
        String type = input.nextLine().trim().toLowerCase();

        Contract contract;

        if (type.equals("sale")) {
            System.out.print("WILL THE CUSTOMER FINANCE? (YES/NO): ");
            boolean finance = input.nextLine().trim().equalsIgnoreCase("yes");
            contract = new SalesContract(customerName, customerEmail, vehicle, finance);
        } else if (type.equals("lease")) {
            if (vehicle.getYear() < LocalDate.now().getYear() - 3) {
                System.out.println("THIS VEHICLE IS TOO OLD TO LEASE.");
                return;
            }
            contract = new LeaseContract(customerName, customerEmail, vehicle);
        } else {
            System.out.println("INVALID CONTRACT TYPE.");
            return;
        }

        // Save contract
        ContractDataManager cdm = new ContractDataManager();
        cdm.saveContract(contract);

        // Remove vehicle from inventory
        dealership.removeVehicle(vin);
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(dealership, "carDealership/src/main/resources/VehicleInventoryList.csv");

        System.out.println("Contract saved and vehicle removed from inventory.");
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