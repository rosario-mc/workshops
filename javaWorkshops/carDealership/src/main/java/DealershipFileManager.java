import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

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
            System.out.println("An error occurred while accessing file: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file: " + e.getMessage());
        }
    }
}
