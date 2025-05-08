public class Vehicle {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(String vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return"\n===========================================================\n" +
                "                    VEHICLE DETAILS       \n" +
                "===========================================================\n" +
                String.format("%-20s: %s%n", "VIN", vin) +
                String.format("%-20s: %d%n", "YEAR", year) +
                String.format("%-20s: %s%n", "MAKE", make) +
                String.format("%-20s: %s%n", "MODEL", model) +
                String.format("%-20s: %s%n", "TYPE", vehicleType) +
                String.format("%-20s: %s%n", "COLOR", color) +
                String.format("%-20s: %,d MILES%n", "ODOMETER READING", odometer) +
                String.format("%-20s: $%,.2f%n", "PRICE", price) +
                "===========================================================\n\n";
    }
}
