package MyApp.src;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {    

    // Mortgage Calculator
    public static void main(String[] args) {
        byte number_of_months = 12;
        byte percent = 100;

        Scanner scanner = new Scanner(System.in);

        int principal;
        do{
        System.out.print("Principal: ");
        principal = scanner.nextInt();
        if(principal >= 1000 && principal <= 1000000)
            break;
        else
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }while(true);    

        float annualInterestRate;
        do{
        System.out.print("Annual interest rate: ");
        annualInterestRate = scanner.nextFloat();
        if(annualInterestRate > 0 && annualInterestRate <= 30)
        break;
        else
            System.out.println("Enter a value greater than 0 and less or equal to 30 !!");    
        }while(true);
        float monthlyInterestRate = annualInterestRate / percent / number_of_months;

        byte period;
        do{
        System.out.print("Period (years): ");
        period = scanner.nextByte();
        if(period > 0 && period <=30)
        break;
        else 
            System.out.println("Enter a number between 0 and 30");
        }while(true);

        int numberOfPayments = period * number_of_months; 

        double Mortgage = principal * ((monthlyInterestRate)* Math.pow((1 + monthlyInterestRate) , numberOfPayments))/(Math.pow((1 + monthlyInterestRate) , numberOfPayments) - 1);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageCurrency = currency.format(Mortgage);
        System.out.println("Mortgage: " + mortgageCurrency);
        
        scanner.close();
    }
}