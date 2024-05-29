import java.util.Comparator;

public class pokemonComparator implements Comparator<pokemon>{

    //always override compare()
    @Override
    public int compare(pokemon o1, pokemon o2) {

        String n1 = o1.getName();
        String n2 = o2.getName();
        
        //always lowercase
        return n1.toLowerCase().compareTo((n2).toLowerCase());
    }

}