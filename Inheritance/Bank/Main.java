import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Bank[] banks = {new EmiratesBank(), new HSBC(), new CitiBank()};
        
        System.out.println("Interest rates before random event:");
        for (Bank bank : banks) {
            System.out.println(bank + " ROI: " + bank.rateOfInterest());
        }

        applyRandomEvent(banks);

        System.out.println("\nInterest rates after random event:");
        for (Bank bank : banks) {
            System.out.println(bank + " ROI: " + bank.rateOfInterest());
        }
    }

    public static void applyRandomEvent(Bank[] banks) {
        Random random = new Random();
        for (Bank bank : banks) {
            if (bank instanceof EmiratesBank) {
                ((EmiratesBank) bank).setRateOfInterest(random.nextFloat() * 5 + 1); //setting new rate between 1% and 6%
            } else if (bank instanceof HSBC) {
                ((HSBC) bank).setRateOfInterest(random.nextFloat() * 5 + 1); //setting new rate between 1% and 6%
            } else if (bank instanceof CitiBank) {
                ((CitiBank) bank).setRateOfInterest(random.nextFloat() * 5 + 1); //setting new rate between 1% and 6%
            }
        }
    }
}
