public class HSBC implements Bank {

    private float rate = 4.2f;

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
        return "HSBC";
    }
}
