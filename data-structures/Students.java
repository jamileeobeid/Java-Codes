import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Students{

    private int ID;
    private String name;
    private String email;

    public Students(int ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }


    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
            " ID='" + this.ID + "'" +
            ", name='" + this.name + "'" +
            ", email='" + this.email + "'" +
            "}";
    }

    @Override
    public int hashCode(){
        return (int) ID*this.name.hashCode();
    }
    
    public static void main(String[] args) {
        
        Students student1 = new Students(123, "Jamile", "jo4065");
        Students student2 = new Students(454, "Raghad", "ra8023");
        Students student3 = new Students(536, "Tan", "ta2934");
        Students student4 = new Students(356, "Hafsa", "hn0394");
        Students student5 = new Students(753, "Lana", "lk9034");

        HashSet <Students> hs = new HashSet<Students> ();
        hs.add(student1);
        hs.add(student2);
        hs.add(student3);
        hs.add(student4);
        hs.add(student5);

        //output will be unordered because we are using hash()
        for(Students student: hs){
            System.out.println(student);
        }

        TreeSet <Students> ts = new TreeSet<Students>(new myNameComparator());
        ts.add(student1);
        for(Students student: ts){
            System.out.println(student);
        }

        System.out.println(student1.hashCode());

        HashMap<String, Students> myhashmap = new HashMap<String, Students>();
        myhashmap.put(student1.getName(), student1);
        myhashmap.put(student2.getName(), student2);
        myhashmap.put(student3.getName(), student3);

        System.out.println(myhashmap);

        TreeMap<String, Students> mytreemap = new TreeMap<String,Students>();
        mytreemap.put(student1.getName(), student1);
        mytreemap.put(student2.getName(), student2);
        mytreemap.put(student3.getName(), student3); 

        for(Students students: mytreemap.values()){
            System.out.println(students);
        }
    }
}
