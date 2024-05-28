public class addition {

    public interface twoNumbers {
        void sum(double num1, double num2);
    }

    public static void main(String[] args) {

        twoNumbers lambda = (double n1, double n2) ->  System.out.println(n1 + n2);
        lambda.sum(4, 4);

        twoNumbers anonymous = new twoNumbers() {
            @Override
            public void sum(double num1, double num2){
                System.out.println(num1 + num2);
            }
        };
        anonymous.sum(4,4);
    }
}