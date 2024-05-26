import java.util.Scanner;

public class Counters {

    public static void main(String[] args) throws InterruptedException{

        Scanner in=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=in.nextInt();
        in.close();

        Thread[] counters=new Thread[num];

        for(int i=0; i<num; i++){
            Runnable counter=new RunnableCounter("Counter " + i);
            counters[i]=new Thread(counter);
            counters[i].start();
        }

        for(int i=0; i<num; i++)
            counters[i].join();
            
        System.out.println("Counting is done!!!!!"); //parent of application
    }
}
