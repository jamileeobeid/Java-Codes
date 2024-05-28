//TASK:
//create a lambda and anonymous class to change all the letters in the string to capital letters

public class upperCase {

    interface someinterface{
        void dosomething(String s);
    }

    public static void main(String[] args) {

        someinterface lambda = a -> System.out.println(a.toUpperCase());
        lambda.dosomething("hello");

        someinterface anonymous = new someinterface(){
            @Override
            public void dosomething(String s){
                System.out.println(s.toUpperCase());
            }
        };
        anonymous.dosomething("hello");
    }
}