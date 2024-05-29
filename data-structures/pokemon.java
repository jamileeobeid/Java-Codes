import java.util.Collections;
import java.util.LinkedList;

public class pokemon implements Comparable<pokemon>{

    private int number;
    private String name;


    public pokemon(int number, String name) {
        this.number = number;
        this.name = name;
    }


    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(pokemon o) {
        return this.number-o.number;
    }

    @Override
    public String toString(){
        return this.number + " : " + this.name;
    }

    public static void main(String[] args) {
        
        pokemon pk1 = new pokemon(5, "Bidoof");
        pokemon pk2 = new pokemon(2, "Pikachu");
        pokemon pk3 = new pokemon(8, "Balbazer");
        LinkedList<pokemon> mylist = new LinkedList<pokemon>();

        mylist.add(pk1);
        mylist.add(pk2);
        mylist.add(pk3);

        Collections.sort(mylist);

        System.out.println(mylist);

        Collections.sort(mylist, new pokemonComparator()); //constructor without the need of a variable

        System.out.println(mylist);
    }
    
}