class reverseInteger {

    public static int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int digit = x % 10; 
  
            //returning 0 if there is overflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            //returning 0 if there is underflow
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        
        return reversed;
    }

    public static void main(String[] args) {

        int result = reverse(123);
        System.out.println(result); //321

        int result2 = reverse(-123);
        System.out.println(result2); //-321

        int result3 = reverse(120);
        System.out.println(result3); //21
        
    }
}
