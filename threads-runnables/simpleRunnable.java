public class simpleRunnable implements Runnable {
    private final int id;

    public simpleRunnable(int id) {
        this.id = id;
    }

    public void run () {
        System.out.println ("The ID number of this thread is: "+id);
    }
    
    public static void main (String[] args) {
        Runnable runnable = new simpleRunnable(1);
        Thread thread = new Thread (runnable);
        thread.start ();
    }
}