public class simpleThread extends Thread {
    
    private String name;

    //constructor
    public simpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=1; i<=5; i++){
            System.out.println(i + " from the thread "+ name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        Thread thread1 = new simpleThread("Thread 1");
        Thread thread2 = new simpleThread("Thread 2");
        thread1.start();
        thread2.start();
    }
}