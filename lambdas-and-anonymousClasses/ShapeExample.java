public class ShapeExample {

    public interface Shape {
        void area (double length);
    }

    public static void main (String[] args) {

        Shape lambda = radius -> System.out.println("Area of the Circle: "+ Math.PI * Math.pow(radius,2));
        lambda.area(5);

        Shape anonymous = new Shape(){
            @Override
            public void area(double length){
                System.out.println("Area of the Circle: "+ Math.PI*Math.pow(length,2));
            }
        };
        anonymous.area(5);
    }
}