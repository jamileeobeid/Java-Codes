public class Mage extends Goat{

    //creating the constructor
    public Mage(String name, int current_HP){
        super(name, current_HP);
    }

    @Override
    public Attack Attack(){
        int [] myhit = new int[]{9, 9, 9, 9};
        Attack myAttack = new Attack("Magic Missiles", myhit, DamageType.Magical);

        //Other side will get points (heal)
        int totalhit=0;
        for(int hit: myhit){
            totalhit += hit;
        }

        Heal(totalhit);
        return myAttack;
    }

    @Override
    public int Damage(Attack incomingAttack){

        int totalhit =0;

        for(int hit: incomingAttack.getHits()){
            totalhit += hit;
        }

        if(incomingAttack.getDamagetype()==DamageType.Physical){
            totalhit *= 1.25; //Adding 25% to the total hit
        }

        if(incomingAttack.getDamagetype()==DamageType.Magical){
            totalhit *= 0.75;  //Removing 25% from the total hit
        }

        current_HP -= totalhit;

        /**if the current_HP becomes less than zero
         * to prevent it from becoming a negative value,
         * we will set it to zero*/
        
        if(current_HP < 0){
            current_HP =0;
        }
        return current_HP;
    }
}
