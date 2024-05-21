//Given a positive integer n, we will return the smallest positive integer that is a multiple of both 2 and n.

public class smallest_even_multi {

    public static int smallestEvenMultiple(int n) {

        int multiple; 

        if((n%2)!=0) multiple = 2*n;
        else multiple = n;
        return multiple;
    }

    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(5)); //10
        System.out.println(smallestEvenMultiple(6)); //6
    }
}
