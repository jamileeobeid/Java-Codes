public class EmiratesBank implements Bank {

    private float rate = 3.4f;

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
        return "EmiratesBank";
    }
}
