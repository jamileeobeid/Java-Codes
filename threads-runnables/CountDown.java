public class CountDown implements Runnable{

    @Override
    public void run(){
        int i=-10;

        String header = "T";

        //we have to use try/catch since we will use .sleep()
        try{
            while(true){

                if(i==0){
                    System.out.println("Liftoff");
                    header="";
                }
                else{
                    System.out.println(header+i);
                }
                Thread.sleep(1000);
                i++;
            }

        }catch(InterruptedException e){}
    }

    public static void main(String[] args) {

        //shortcut for thread creation using runnable interface
        new Thread(new CountDown()).start();
    }
}
//we did not set any conditions so the while loop will go on forever