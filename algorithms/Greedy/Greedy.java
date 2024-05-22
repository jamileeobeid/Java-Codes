import java.util.ArrayList;
import java.util.Scanner;
/**
 * Greedy algorithm implementation for the Making change problem
 */
public class Greedy {
    /**Currency enum represents bills used to return change  to customer */
    public enum Currency
    {
        DOLLAR(1,"Dollar"),
        QUARTER(0.25,"Qarter"),
        PENNY(0.01, "Penny");

        public double bill;
        public String name;

        Currency(double bill, String name)
        {
            this.bill=bill;
            this.name=name;
        }

        public double getCurrency()
        {
            return this.bill;
        }

        public String toString()
        {
            return this.name;
        }
    }

    /**
     * Make Change method is impementation of greedy algorithm for calculating optimal way to return change to the customer.
     * @param price of the articles (double)
     * @param payment money provided by customer (double)
     * @return array of Currency enum representing optimal way to return change to customer
     */
    public static ArrayList <Currency> makeChange(double price, double payment)
    {
        ArrayList <Currency> change = new ArrayList<Currency>();

        while(payment<price)
        {
            System.out.println("Payment is insufficient, provide more money");
            Scanner scanner = new Scanner(System.in);
            payment=scanner.nextDouble();
            scanner.close();
        }
        double change_amount=payment-price;
        System.out.println("Change is: "+change_amount);
        while(change_amount>0)
        {
            if(change_amount>Currency.DOLLAR.getCurrency())
            {
                change.add(Currency.DOLLAR);
                change_amount--;
            }
            else if(change_amount>Currency.QUARTER.getCurrency())
            {
                change.add(Currency.QUARTER);
                change_amount=change_amount-Currency.QUARTER.getCurrency();
            }
            else
            {
                change.add(Currency.PENNY);
                change_amount=change_amount-Currency.PENNY.getCurrency();
            }
        }
        return change;
    }

    public static void main(String[] args)
    {
        ArrayList<Currency> result=makeChange(123.4,120);
        for(Currency i : result)
            System.out.println(i);
    }
}
