class addDigits {

    //the idea of this code is to epeatedly add all the digits
    // until the result has only one digit, and return it. 
    public static int adding(int num) {

        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum = sum + (num % 10);
                num = num/10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(adding(38)); //3+8 = 11, 1+1 = 2
        System.out.println(adding(0));
        System.out.println(adding(57)); //5+7 = 12, 1+2 = 3
    }
}