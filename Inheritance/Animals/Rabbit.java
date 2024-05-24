public class Rabbit extends Animal{

    private String name;

    public Rabbit(String name){
        this.name = name;
    }

    @Override
    public void eat(){
        System.out.println("I eat carrots");
    }

    public void size(){
        System.out.println("I am small in size");
    }

    @Override
    public String toString(){
        return "My name is: "+name;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Rabbit)){
            return false;
        }
        Rabbit other = (Rabbit)o;
        return this.name.equals(other.name);
    }

    public static void main(String[] args) {
        
        Animal rabbit1 = new Rabbit("Rabbit-1");
        rabbit1.eat();
        Rabbit rabbit2 = new Rabbit("Rabbit-2");
        rabbit2.size();
        System.out.println(rabbit1);
        System.out.println(rabbit2);
        System.out.println(rabbit1.equals(rabbit2));
    }

}
