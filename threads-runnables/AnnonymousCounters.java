import java.util.Scanner;

public class AnnonymousCounters {

    private static void counter(String name){
        int count =1;

        while(count<5){
            System.out.println(name+" : "+count);
            count++;
        }
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of counters to count: ");
        int num = in.nextInt();
        in.close();

        for(int i=0; i<num; i++){
            Thread countThread = null;
            String name="Counter "+i;

            if(i%2==0){ //we will only print the even numbered counters
                countThread = new Thread(new Runnable(){
                    public void run(){
                        counter(name);
                    }
                });

            }else{
                countThread=new Thread();
            }
    
            countThread.start();
        }
    }

}