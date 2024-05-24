// Animal interface
interface Animals {
    void eat();

    void makeSound();
}



// Rabbit class implementing the Animal interface

class Rabbits implements Animals {

    @Override
    public void eat() {
        System.out.println("Rabbit is eating.");
    }

    @Override
    public void makeSound() {
        System.out.println("Rabbit makes a sound.");
    }

    public void hop() {
        System.out.println("Rabbit is hopping.");
    }
}



// Sheep class implementing the Animal interface

class Sheep implements Animals {

    @Override
    public void eat() {
        System.out.println("Sheep is eating.");
    }


    @Override
    public void makeSound() {
        System.out.println("Sheep makes a sound.");
    }

    public void produceWool() {
        System.out.println("Sheep gives us Wool.");
    }
}



//main class for testing

class MainClass {
    public static void main(String[] args) {
        
        Animals rabbit = new Rabbits();

        //calling methods through Animal interface
        rabbit.eat();
        rabbit.makeSound();
        // wrong rabbit.hop();

        //Rabbit-specific method
        ((Rabbits) rabbit).hop(); // Casting rabbit to Rabbit to call hop() method


        Animals sheep = new Sheep();

        //calling methods through Animal interface
        sheep.eat();
        sheep.makeSound();

        //wrong sheep.produceWool();

        //Rabbit-specific method
        ((Sheep) sheep).produceWool(); // Casting rabbit to Rabbit to call hop() method

    }
}
