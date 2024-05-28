interface Greeting {
    void sayHello();
}

class HelloGreeting implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("Hello from HelloGreeting");
    }

}

interface Calculator {
    int calculate(int x, int y);
}

//you can run this code from the main class in Main.java