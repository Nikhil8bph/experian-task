package com.currency.exp;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CurrencyUtils {
    public static List<Currency> createCurrencyEntry() {
        return List.of(
                new Currency(1, "p", 100, Type.coin),
                new Currency(2, "p", 300, Type.coin),
                new Currency(5, "p", 10, Type.coin),
                new Currency(20, "p", 3, Type.coin),
                new Currency(50, "p", 3, Type.coin),
                new Currency(1, "\u00A3", 3, Type.coin),
                new Currency(2, "\u00A3", 3, Type.coin),
                new Currency(5, "\u00A3", 7, Type.note),
                new Currency(10, "\u00A3", 6, Type.note),
                new Currency(20, "\u00A3", 7, Type.note),
                new Currency(50, "\u00A3", 6, Type.note)
        );
    }

    public static List<Currency> methodAddData(Scanner sc, List<Currency> currencies) {
        currencies.forEach(currency -> {
            while (true) {
                    System.out.print(format("Enter the number of denominations for %s%s: ", currency.getValue(), currency.getName()));
                    int input = sc.nextInt();
                    if (input < 0) {
                        System.out.println("Number of denominations cannot be negative. Try again.");
                        continue;
                    }
                    currency.setSku(input);
                    break;
            }
        });
        return currencies;
    }

    public static double totalAmount(List<Currency> currencies) {
        double total = 0;
        for (Currency currency : currencies) {
            total += currency.getActualValue() * currency.getSku();
        }
        return total;
    }

    public static void printDenominations(List<Currency> currencies) {
        System.out.println("Available Denominations:");
        for (Currency currency : currencies) {
            System.out.println(format("%d x %s%s", currency.getSku(), currency.getValue(), currency.getName()));
        }
    }

    public static double calculateChange(double totalAmount, double productCost) {
        if (totalAmount < productCost) {
            System.out.println("Insufficient amount given. Please try again.");
            return 0;
        }
        return totalAmount - productCost;
    }

    public static void printChangeDenominations(double changeAmount, List<Currency> currencies) {
        if (changeAmount <= 0) {
            System.out.println("No change is needed.");
            return;
        }

        currencies = currencies.stream()
                .filter(curr -> curr.getSku() > 0)
                .sorted((a, b) -> Double.compare(b.getActualValue(), a.getActualValue()))
                .collect(Collectors.toList());

        Map<Currency, Integer> changeMap = new LinkedHashMap<>();
        for (Currency currency : currencies) {
            int count = (int) (changeAmount / currency.getActualValue());
            if (count > 0) {
                count = Math.min(count, currency.getSku());
                if (count > 0) {
                    changeMap.put(currency, count);
                    currency.setSku(currency.getSku() - count);
                    changeAmount -= count * currency.getActualValue();
                }
            }

            if (changeAmount < 0.01) {
                changeAmount = 0;
                break;
            }
        }

        if (changeAmount > 0.01) {
            System.out.println("Insufficient denominations to provide the exact change.");
        } else {
            System.out.println("Change denominations:");
            for (Map.Entry<Currency, Integer> entry : changeMap.entrySet()) {
                Currency currency = entry.getKey();
                int count = entry.getValue();
                System.out.println(format("%d x %s%s", count, currency.getValue(), currency.getName()));
            }
        }

        System.out.println("\nAvailable Denominations:");
        currencies.forEach(currency -> System.out.println(
                format("%d x %.1f%s", currency.getSku(), currency.getValue(), currency.getName())));
    }

}