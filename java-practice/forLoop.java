public class forLoop {

    public static double countFor(int n){

        //result is the sum of numbers from 0 till n
        double result = 0;

        for(int i=0; i<n; i++){
            result = result + i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countFor(10));
    }
}

