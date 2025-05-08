import java.util.Scanner;

public class calculator1Mortgage {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Calc 1 (monthly payment loan)
        //principal
        double principalAmount = getPrincipalAmount();

        //interest rate
        double interestRate = getInterestRate();

        //loan length
        double loanLengthYears = getLoanLength();

        //calculate monthly interest paid
        double monthlyInterestRate = getMonthlyInterestRate(principalAmount , interestRate , loanLengthYears);

        //calculate annual interest paid
        double annualInterestRate = getAnnualInterestRate(principalAmount, monthlyInterestRate);

        //calculate number of monthly payments
        double numberOfPayments = getNumberOfPayments(loanLengthYears);

        //calculate monthly payment
        double monthlyPayment = getMonthlyPayment(principalAmount , monthlyInterestRate , loanLengthYears);
        //display

        scanner.close();
    }

    public static double getPrincipalAmount (){
        System.out.println("What is the principal amount?:");
        double principalAmount = scanner.nextDouble();
        return principalAmount;
    }

    public static double getInterestRate(){
        System.out.println("What is the interest rate? (e.g., 5.5%): ");
        double interestRate = scanner.nextDouble();
        return interestRate;
    }

    public static double getLoanLength(){
        System.out.println("What is the loan length in years?: ");
        double loanLengthYears = scanner.nextInt();
        return loanLengthYears;
    }

    public static double getMonthlyInterestRate(double principalAmount , double interestRate , double loanLength){
        double monthlyInterestRate = interestRate / 100 / 12;
        return monthlyInterestRate;
    }

    public static double getNumberOfPayments(double loanLengthYears){
        double numberOfPayments = loanLengthYears * 12;
        return numberOfPayments;
    }

    public static double getAnnualInterestRate(double monthlyInterestRate, double principalAmount){
        double annualInterestRate = monthlyInterestRate * principalAmount;
        System.out.printf("Total interest paid: $%.2f" , annualInterestRate);
        return annualInterestRate;
    }

    public static double getMonthlyPayment(double principalAmount , double monthlyInterestRate , double loanLengthYears , double numberOfPayments){
        double monthlyPayment = principalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanLengthYears ) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        System.out.println("Monthly payment: " + monthlyPayment);
        return monthlyPayment;
    }
}
