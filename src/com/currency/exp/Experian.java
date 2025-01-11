package com.currency.exp;

import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Experian {
    static List<Currency> currencies = CurrencyUtils.createCurrencyEntry();
    static double totalAmountAvailable = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter\n"+
                            "Please choose an option:\n"+
                            "1. Modify denominations manually\n"+
                            "2. Use default denominations");

        int option = sc.nextInt();
        if (option == 1) {
                currencies = CurrencyUtils.methodAddData(sc, currencies);
        } else if (option == 2) {
                System.out.println("Using default denominations.");
        }
        totalAmountAvailable = CurrencyUtils.totalAmount(currencies);
        CurrencyUtils.printDenominations(currencies);
        System.out.println("Available amount is : "+totalAmountAvailable);

        while(totalAmountAvailable>0) {
            System.out.print("Enter the product cost: ");
            double productCost = sc.nextDouble();
            System.out.print("Enter the total amount given: ");
            double totalAmount = sc.nextDouble();
            if(productCost<0 || totalAmount<0){
                System.out.println("Invalid amount entered. Please try again.");
            } else {
                double changeAmount = CurrencyUtils.calculateChange(totalAmount, productCost);
                System.out.println(format("Change to be returned: %.2f", changeAmount));
                CurrencyUtils.printChangeDenominations(changeAmount, currencies);
                CurrencyUtils.printDenominations(currencies);
                totalAmountAvailable = CurrencyUtils.totalAmount(currencies);
                System.out.println("Available amount is : " + CurrencyUtils.totalAmount(currencies));
            }
        }
        sc.close();
    }
}
