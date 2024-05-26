public class Alphabets extends Thread{

    private final String name;

    //constructor
    public Alphabets(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(char ch='A'; ch<='Z'; ch++){
            System.out.println(name +": "+ch);
        }
    }
    
    public static void main(String[] args) {
        Thread thread1 = new Alphabets("Letter");
        thread1.start();
    }
    
}
