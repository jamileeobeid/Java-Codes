public class casting {

    public static void main(String[] args) {
        
        //integer to long
        int x = 123;
        long inttolong = (long)x; //123

        //long >3 million to int
        long a = 4000000l;
        int longtoint = (int)a; //4000000

        //char to int
        char letter = 'e';
        int chartoint = (int)letter; //101

        //int in the range 33<i<126 to char
        int n = 126;

        for(int i=34; i<n; i++){
            char inttochar = (char)i; 
        }

        //Boolean to integer
        boolean statement = true;
        int w = (int)statement;  //compilation error

    }

}
