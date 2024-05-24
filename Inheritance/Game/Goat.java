public abstract class Goat {

    protected String name;
    protected final int MAX_HP=100; //creating a global variable (constant)
    protected int current_HP;

    //creating getters

    public String getName() {
        return this.name;
    }

    public int getMAX_HP() {
        return this.MAX_HP;
    }

    public int getCurrent_HP() {
        return this.current_HP;
    }

    //creating the constructor
    public Goat(String name, int current_HP){
        this.name = name;
        this.current_HP = current_HP;
    }

    public abstract Attack Attack();

    public void Heal(int hitpoints){

        if((current_HP < MAX_HP) && (MAX_HP > current_HP + hitpoints)){
            current_HP = current_HP + hitpoints;
        }
        else if(MAX_HP <= current_HP + hitpoints){
            current_HP = MAX_HP;
        }

    }

    public abstract int Damage(Attack incomingAttack);

    public boolean isConscious(){

        if(current_HP <= 0){
            return true;
        }
        return false;
    }
}
