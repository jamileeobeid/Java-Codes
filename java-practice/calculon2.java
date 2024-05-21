public class calculon2 {

    public static float raise(float base, int exponent){
        
        float result = 1;

        for(int i=1; i<=exponent; i++){
            result = result * base;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(raise(5,2));
    }

}
