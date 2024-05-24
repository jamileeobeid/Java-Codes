public class CitiBank implements Bank {

    private float rate = 2.9f;

    @Override
    public float rateOfInterest() {
        return rate;
    }
    
    //creating a setter
    public void setRateOfInterest(float rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString() {
        return "CitiBank";
    }
}
