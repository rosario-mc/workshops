public class SalesContract extends Contract{
    private final double salesTax = .05;
    private final double recordingFee = 100;
    private final double processingFeeUnder10k = 295;
    private final double processingFeeElse = 495;
    private boolean finance;

    public SalesContract(String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFeeUnder10k() {
        return processingFeeUnder10k;
    }

    public double getProcessingFeeElse() {
        return processingFeeElse;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        double price = vehicleSold.getPrice(); // assuming Vehicle has getPrice()
        double taxAmount = price * salesTax;
        double fee = price < 10000 ? processingFeeUnder10k : processingFeeElse;

        return price + taxAmount + recordingFee + fee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) return 0.0;

        double amount = getTotalPrice();
        double monthlyRate;
        int months;

        if (vehicleSold.getPrice() >= 10000) {
            monthlyRate = 0.0425 / 12;
            months = 48;
        } else {
            monthlyRate = 0.0525 / 12;
            months = 24;
        }

        return (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
