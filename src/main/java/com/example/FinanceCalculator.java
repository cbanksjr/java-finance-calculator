package com.example;

import java.util.Scanner;

import lombok.Data;

@Data
public class FinanceCalculator {
    Scanner input = new Scanner(System.in);

    private double amount;
    private double moneyValue;
    private double remainingAmount;
    private double percentage;

    /**
     * Constructor
     * 
     * @param amount
     * @param percentage
     * @param moneyValue
     */
    public FinanceCalculator(double amount, double moneyValue, double percentage, double remainingAmount) {
        this.amount = amount;
        this.percentage = percentage;
        this.moneyValue = moneyValue;
        this.remainingAmount = remainingAmount;

    }


    /**
     * Takes input for amount of money
     * 
     * @return
     */
    public double deduction() {
            System.out.println("Enter money amount:");
            double moneyInAccount = input.nextDouble();
            setMoneyValue(moneyInAccount);
            //Checks if amount entered is less than 0
            if(moneyInAccount <= 0){
                System.out.println("Invalid entry! Positive numbers only!");
                runCalculator();
            }
            return moneyInAccount;
        }
            
        /**
         * Turns int into a double to get percent
         * @return
         */
    public double percentInput() {
        System.out.println("Enter percent you want to deduct:");
        double percent = input.nextDouble();
        setPercentage(percent / 100);
        //Checks if amount entered is less than 0
         if(percent <= 0 ){
            System.out.println("Invalid entry! Positive numbers only!");
            runCalculator();
        }
        return percent;
    }

    /**
     * Multiplies two values to get amount to be allocated
     * @return
     */
    public double total(){
        double result = getMoneyValue() * getPercentage();
        setAmount(result);
        return result;
    }

    /**
     * Subtracts amount from moneyInAccount and total
     * 
     * @return amount left over after deduction
     */
    public double leftOverAmount() {
        double amountLeft = getMoneyValue() - getAmount();
        setRemainingAmount(amountLeft);
        return amountLeft;
    }

    /**
     * Takes input. Breaks out of program if no more deductions and continues if
     * there are.
     */
    public void endDeductions() {
        System.out.println("Would you like to make any more deductions? Y or N?");
        String decision = input.next();
        while(true){
            if (decision.equalsIgnoreCase("N")) {
                System.out.println("No more deductions needed");
                break;
            } else {
                runCalculator();
            }
            break;
        }
        
    }

    /**
     * method to run other methods in main method
     */
    public void runCalculator() {
        deduction();
        percentInput();
        total();
        leftOverAmount();
        System.out.println(toString());
        endDeductions();
    }

    
    @Override
    public String toString() {
        return String.format("Take out $%.2f dollars. Your remaining amount is $%.2f dollars %n", getAmount(),
                getRemainingAmount());
    }
}
