import java.util.Scanner;
public class calculon3 {

    //creating Add method for adding two numbers 
    public static float Add(float firstnumber, float secondnumber){
        float addition = firstnumber + secondnumber;
        return addition;
            
    }

    //creating Subtract method for subtracting two numbers
    public static double Subtract(double firstnumber, double secondnumber) {
        double subtract = firstnumber - secondnumber;
        return subtract;
    }
        
    //creating Divide method for dividing two numbers
    public static double Divide(double firstnumber, double secondnumber) {
        double division = firstnumber / secondnumber;
        return division;

    }

    public static void main(String[] args) {
        
        Scanner myscanner = new Scanner(System.in);
        System.out.print("Enter your first number: ");
        int firstnumber = myscanner.nextInt();
        System.out.print("Enter your second number: ");
        int secondnumber = myscanner.nextInt();

        System.out.println("Numbers added: "+Add(firstnumber, secondnumber));
        System.out.println("Numbers subtrcated: "+Subtract(firstnumber, secondnumber));
        System.out.println("Numbers divided: "+Divide(firstnumber, secondnumber));

        myscanner.close();
    }

}
