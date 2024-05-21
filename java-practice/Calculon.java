public class Calculon {

    //creating Add method for adding two numbers 
    public static double Add(double firstnumber, double secondnumber){

        double addition = firstnumber + secondnumber;
        return addition;
    
    }
    
    //creating Divide method for dividing two numbers
    public static double Divide(double firstnumber, double secondnumber) {
        double division = firstnumber / secondnumber;
        return division;
    }

    public static void main(String[] args) {
        
        System.out.println(Add(5,5));
        System.out.println(Divide(10,2));
    }

}

