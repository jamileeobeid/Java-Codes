/* TASK: Create a Java program that simulates a countdown timer using threads. 
Define a CountdownTimer class that extends Thread and takes an initial countdown value in seconds as a parameter in its constructor. 
Implement the run method to decrement the countdown value every second and print the remaining time. 
When the countdown reaches zero, print a message indicating that the countdown is complete.

In your main method, create two instances of the CountdownTimer class with different initial countdown values (e.g., 10 seconds and 5 seconds). 
Start both timers simultaneously and observe their countdowns independently. */

public class CountDownTimer extends Thread{

    int initialCountDown = 10;
    public CountDownTimer(int initialCountDown){
        this.initialCountDown = initialCountDown;
    }
    @Override
    public void run(){

        try {
            for(int i=initialCountDown; i>=0; i--){
                System.out.println("Remaining time: "+i);
                sleep(1000);
            }
            System.out.println("Counting is Over!");
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new CountDownTimer(10);
        Thread thread2 = new CountDownTimer(5);
        thread1.start();
        thread1.join();
        thread2.start();
    }
    
}
