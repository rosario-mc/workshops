public class LeaseContract extends Contract {
    private final double expectedEndingValueRate = 0.5;
    private final double leaseFee = 0.07;

    public LeaseContract(String dateOrContract, String customerName, String customerEmail, Vehicle vehicleSold) {
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
        double price = vehicleSold.getPrice();
        double endingValue = price * expectedEndingValueRate;
        double leaseFeeAmount = price * leaseFee;

        return endingValue + leaseFeeAmount;
    }

    @Override
    public double getMonthlyPayment() {
        double amount = getTotalPrice();
        double monthlyRate = 0.04 / 12;
        int months = 36;

        return (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
