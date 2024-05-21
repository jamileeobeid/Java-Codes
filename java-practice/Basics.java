public class Basics {

    public static void main(String[] args) {

        /*printing the numbers between 0-100 that
        are multiples of 3 or 7 but not both */

        int n = 100;

        for(int i=0; i<n; i++){

            if((i % 3 == 0) && (i % 7 ==0)){
                continue;
            }
            else if((i % 3 == 0) || (i % 7 ==0)){
                System.out.println(i);
            }
        }
    }

}
