public class SalesContract extends Contract{
    private final double salesTax = .05;
    private final double recordingFee = 100;
    private final double processingFeeUnder10k = 295;
    private final double processingFeeElse = 495;
    private boolean finance;

    public SalesContract(String dateOrContract, String customerName, String customerEmail, String vehicleSold, boolean finance) {
        super(dateOrContract, customerName, customerEmail, vehicleSold);
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
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
