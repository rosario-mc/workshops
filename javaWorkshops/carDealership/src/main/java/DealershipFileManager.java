import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    static Scanner input = new Scanner(System.in);

    public static Dealership getDealership(String filename) throws IOException {
        Dealership dealership = new Dealership(); // Create empty dealership

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 8) {
                    String vin = parts[0].trim();
                    int year = Integer.parseInt(parts[1].trim());
                    String make = parts[2].trim();
                    String model = parts[3].trim();
                    String type = parts[4].trim();
                    String color = parts[5].trim();
                    int odometer = Integer.parseInt(parts[6].trim());
                    double price = Double.parseDouble(parts[7].trim());

                    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("ERROR READING VEHICLE DATA: " + e.getMessage());
        }

        return dealership;
    }

    public void appendVehicle(Vehicle vehicle, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.printf("%s|%d|%s|%s|%s|%s|%d|%.2f%n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        } catch (IOException e) {
            System.out.println("FAILED TO APPEND VEHICLE: " + e.getMessage());
        }
    }

    public void saveDealership(Dealership dealership, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("WELCOME TO DEALERSHIP!");

            for (Vehicle v : dealership.getAllVehicles()) {
                writer.println(String.format("%s|%d|%s|%s|%s|%s|%d|%.2f",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice()));
            }
        } catch (IOException e) {
            System.out.println("FAILED TO SAVE DEALERSHIP: " + e.getMessage());
        }
    }

    public static void printVehicleListByFilter(String filename) {
        try {
            System.out.println("===========================================================\nENTER FILTER BY:\n");
            String filterBy = input.nextLine().trim().toUpperCase();
            if (!filterBy.matches("[A-Z ]+")) {
                System.out.println("\nFILTER BY MUST ONLY CONTAIN LETTERS AND SPACES.\n");
                return;
            }

            Dealership dealership = getDealership(filename);
            List<Vehicle> vehicles = dealership.getAllVehicles();
            System.out.println("\n===========================================================\n FILTER BY " + filterBy + ":\n");

            boolean found = false;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.toString().toUpperCase().contains(filterBy)) {
                    System.out.println(vehicle);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("\nNO VEHICLES MATCHING FILTER: " + filterBy + "\n");
            }
        } catch (IOException e) {
            System.out.println("AN ERROR OCCURRED WHILE ACCESSING FILE: " + e.getMessage() + "\n");
        }
    }

    public static void printVehicleListInRange(String filename, int filterIndex) {
        System.out.println("===========================================================\nENTER START RANGE:\n");
        int startRange = Integer.parseInt(input.nextLine().trim());

        System.out.println("\nENTER END RANGE:\n");
        int endRange = Integer.parseInt(input.nextLine().trim());

        try {
            System.out.println("=======================================================\nFILTER BY RANGE:\n");

            Dealership dealership = getDealership(filename);
            List<Vehicle> vehicles = dealership.getAllVehicles();

            for (Vehicle vehicle : vehicles) {
                int value = switch (filterIndex) {
                    case 1 -> vehicle.getYear();
                    case 6 -> vehicle.getOdometer();
                    case 7 -> (int) vehicle.getPrice();
                    default -> -1; // Invalid index
                };

                if (value >= startRange && value <= endRange) {
                    System.out.println(vehicle);
                }
            }

        } catch (IOException e) {
            System.out.println("AN ERROR OCCURRED WHILE ACCESSING FILE: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("INVALID NUMBER INPUT: " + e.getMessage());
        }
    }
}
