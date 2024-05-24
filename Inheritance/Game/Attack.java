public class Attack {

    private String name;
    private int[] hits;
    private DamageType damagetype; //enum type

    //creating a constructor
    public Attack(String name, int[] hits, DamageType damagetype){
        this.name = name;
        this.hits = hits;
        this.damagetype = damagetype;
    }

    //creating getters
    public String getName() {
        return this.name;
    }

    public int[] getHits() {
        return this.hits;
    }

    public DamageType getDamagetype() {
        return this.damagetype;
    }

}
