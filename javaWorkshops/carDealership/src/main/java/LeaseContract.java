public class LeaseContract extends Contract {
    private final double expectedEndingValueRate = 0.5;
    private final double leaseFee = 0.07;

    public LeaseContract(String dateOrContract, String customerName, String customerEmail, String vehicleSold) {
        super(dateOrContract, customerName, customerEmail, vehicleSold);
    }

    public double getExpectedEndingValueRate() {
        return expectedEndingValueRate;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
