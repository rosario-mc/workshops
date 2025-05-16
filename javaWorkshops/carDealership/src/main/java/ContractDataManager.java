import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    private static final String contractFile = "carDealership/src/main/resources/Contracts.csv";

    public void saveContract(Contract contract) {
        try (FileWriter writer = new FileWriter(contractFile, true)) {
            String line = buildContractLine(contract);
            writer.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }

    private String buildContractLine(Contract contract) {
        StringBuilder sb = new StringBuilder();

        Vehicle v = contract.getVehicleSold();

        if (contract instanceof SalesContract) {
            SalesContract sc = (SalesContract) contract;
            sb.append("SALE|")
                    .append(contract.getDateOfContract()).append("|")
                    .append(contract.getCustomerName()).append("|")
                    .append(contract.getCustomerEmail()).append("|")
                    .append(v.getVin()).append("|")
                    .append(v.getYear()).append("|")
                    .append(v.getMake()).append("|")
                    .append(v.getModel()).append("|")
                    .append(v.getVehicleType()).append("|")
                    .append(v.getColor()).append("|")
                    .append(v.getOdometer()).append("|")
                    .append(v.getPrice()).append("|")
                    .append(v.getPrice() * sc.getSalesTax()).append("|")
                    .append(sc.getRecordingFee()).append("|")
                    .append(v.getPrice() < 10000 ? sc.getProcessingFeeUnder10k() : sc.getProcessingFeeElse()).append("|")
                    .append(sc.getTotalPrice()).append("|")
                    .append(sc.isFinance() ? "YES" : "NO").append("|")
                    .append(sc.getMonthlyPayment());
        } else if (contract instanceof LeaseContract) {
            LeaseContract lc = (LeaseContract) contract;
            double endingValue = v.getPrice() * lc.getExpectedEndingValueRate();
            double leaseFeeAmount = v.getPrice() * lc.getLeaseFee();
            sb.append("LEASE|")
                    .append(contract.getDateOfContract()).append("|")
                    .append(contract.getCustomerName()).append("|")
                    .append(contract.getCustomerEmail()).append("|")
                    .append(v.getVin()).append("|")
                    .append(v.getYear()).append("|")
                    .append(v.getMake()).append("|")
                    .append(v.getModel()).append("|")
                    .append(v.getVehicleType()).append("|")
                    .append(v.getColor()).append("|")
                    .append(v.getOdometer()).append("|")
                    .append(v.getPrice()).append("|")
                    .append(endingValue).append("|")
                    .append(leaseFeeAmount).append("|")
                    .append(lc.getTotalPrice()).append("|")
                    .append(lc.getMonthlyPayment());
        }

        return sb.toString();
    }
}