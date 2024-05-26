public class cities extends Thread{

    String city;

    public cities(String city){
        this.city=city;
    }

    @Override
    public void run(){

        try{
            for(int i=0; i<=10; i++){
                System.out.println(i + " "+city);
                sleep(1000);
            }
            System.out.println("Done! "+city);

        }catch(InterruptedException e){e.printStackTrace();}
    }

    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new cities("Tokyo");
        Thread thread2 = new cities("Brooklyn");
        thread1.start();
        thread1.join();
        thread2.start();
    }

}
