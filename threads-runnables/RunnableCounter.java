public class RunnableCounter implements Runnable{

    private final String name;

    //constructor
    public RunnableCounter(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=1; i<10; i++){
            System.out.println(name+": "+i);
        }
    }

}