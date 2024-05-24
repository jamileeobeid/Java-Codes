public class Game {

    public static void main(String[] args) {
        
        Mage mg1 = new Mage("Mage 1", 100);
        Mage mg2 = new Mage("Mage 2", 50);

        mg1.Damage(mg2.Attack());
        System.out.println(mg1.getName()+ " >> HP: "+ mg1.getCurrent_HP());
        System.out.println(mg2.getName()+ " >> HP: "+ mg2.getCurrent_HP());

    }

}
