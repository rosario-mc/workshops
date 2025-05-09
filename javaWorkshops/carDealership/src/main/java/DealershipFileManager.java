import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    static Scanner input = new Scanner(System.in);

    public void getDealership(){

    }
    public void saveDealership(){

    }

    public static List<String> readAllLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static void printVehicleListByFilter(String filename) {
        try {
            System.out.println("===========================================================\nENTER FILTER BY:\n");
            String filterBy = input.nextLine().trim().toUpperCase();
            if (!filterBy.matches("[A-Z ]+")) {
                System.out.println("\nFILTER BY MUST ONLY CONTAIN LETTERS AND SPACES.\n");
                return;
            }

            List<String> lines = readAllLines(filename);
            System.out.println("\n===========================================================\n FILTER BY " + filterBy + ":\n");

            boolean found = false;

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.toUpperCase().contains(filterBy)) {
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
                        System.out.println(vehicle);  // Calls your @Override toString
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("\nNO CARS MATCHING FILTER: " + filterBy + "\n");
            }
        } catch (IOException e) {
            System.out.println("AN ERROR OCCURRED WHILE ACCESSING FILE: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("ERROR PARSING VEHICLE DATA: " + e.getMessage());
        }
    }

    public static void printVehicleListByIndex(String filename, String header, int filterIndex, String filterValue) {
        try {
            System.out.println("===========================================================\n" + header );
            List<String> lines = readAllLines(filename);


            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split("\\|");

                if (parts.length >= 8) {
                    if (filterValue == null || parts[filterIndex].trim().equalsIgnoreCase(filterValue.trim())) {

                        String vin = parts[0].trim();
                        int year = Integer.parseInt(parts[1].trim());
                        String make = parts[2].trim();
                        String model = parts[3].trim();
                        String type = parts[4].trim();
                        String color = parts[5].trim();
                        int odometer = Integer.parseInt(parts[6].trim());
                        double price = Double.parseDouble(parts[7].trim());

                        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

                        System.out.println(vehicle);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("AN ERROR OCCURRED WHILE ACCESSING FILE: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("ERROR PARSING VEHICLE DATA: " + e.getMessage());
        }
    }

    public static void printVehicleListInRange(String filename, int filterIndex) {
        System.out.println("===========================================================\nENTER START RANGE:\n");
        int startRange = Integer.parseInt(input.nextLine().trim());

        System.out.println("\nENTER END RANGE:\n");
        int endRange = Integer.parseInt(input.nextLine().trim());

        try {
            System.out.println("=======================================================\nFILTER BY RANGE:\n");
            List<String> lines = readAllLines(filename);

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split("\\|");

                if (parts.length > filterIndex) {
                    int value = Integer.parseInt(parts[filterIndex].trim());

                    if (value >= startRange && value <= endRange) {
                        String vin = parts[0].trim();
                        int year = Integer.parseInt(parts[1].trim());
                        String make = parts[2].trim();
                        String model = parts[3].trim();
                        String type = parts[4].trim();
                        String color = parts[5].trim();
                        int odometer = Integer.parseInt(parts[6].trim());
                        double price = Double.parseDouble(parts[7].trim());

                        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

                        System.out.println(vehicle);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("AN ERROR OCCURRED WHILE ACCESSING FILE: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("INVALID NUMBER INPUT: " + e.getMessage());
        }
    }
}
