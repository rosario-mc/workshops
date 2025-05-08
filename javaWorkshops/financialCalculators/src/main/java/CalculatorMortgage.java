import java.util.Scanner;

public class CalculatorMortgage {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Calc 1 (monthly payment loan)
        // principal
        double principalAmount = getPrincipalAmount();

        // interest rate
        double interestRate = getInterestRate();

        // loan length
        double loanLengthYears = getLoanLength();

        // calculate monthly interest paid
        double monthlyInterestRate = getMonthlyInterestRate(interestRate);

        // calculate number of monthly payments
        double numberOfPayments = getNumberOfPayments(loanLengthYears);

        // calculate monthly payment
        double monthlyPayment = getMonthlyPayment(principalAmount, monthlyInterestRate, numberOfPayments);

        // calculate annual interest paid
        double annualInterestPaid = getAnnualInterestPaid(principalAmount, monthlyPayment, numberOfPayments);

        // display results
        System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.printf("Total interest paid over the loan period: $%.2f\n", annualInterestPaid);

        scanner.close();
    }

    public static double getPrincipalAmount() {
        System.out.println("What is the principal amount?:");
        return scanner.nextDouble();
    }

    public static double getInterestRate() {
        System.out.println("What is the interest rate? (e.g., 5.5%): ");
        return scanner.nextDouble();
    }

    public static double getLoanLength() {
        System.out.println("What is the loan length in years?: ");
        return scanner.nextInt();
    }

    public static double getMonthlyInterestRate(double interestRate) {
        return interestRate / 100 / 12; // Convert annual interest rate to monthly
    }

    public static double getNumberOfPayments(double loanLengthYears) {
        return loanLengthYears * 12; // Calculate the number of monthly payments
    }

    public static double getMonthlyPayment(double principalAmount, double monthlyInterestRate, double numberOfPayments) {
        // Formula for monthly mortgage payment
        return principalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    public static double getAnnualInterestPaid(double principalAmount, double monthlyPayment, double numberOfPayments) {
        // Total paid is monthly payment * number of payments, then subtract principal amount to find interest
        double totalPaid = monthlyPayment * numberOfPayments;
        return totalPaid - principalAmount;
    }
}
