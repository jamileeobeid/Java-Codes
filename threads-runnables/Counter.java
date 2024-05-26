import java.util.Scanner;

public class Counter {
    
    private static void counter(String name){
        int count =1;

        while(count<5){
            System.out.println(name+" : "+count);
            count++;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of counters to count: ");
        int num = in.nextInt();
        in.close();

        Thread[] counters = new Thread[num];

        for(int i=1; i<=num; i++){
            Runnable counter = new RunnableCounter("Counter "+ i);
            counters[i] = new Thread(counter);
            counters[i].start();
        }
        
        for(int i=1; i<=num; i++)
            counters[i].join();
        System.out.println("Counting is done!");
        
    }


}
