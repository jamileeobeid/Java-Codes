public interface WGraph<E> {

    void add(E value);
    boolean contains(E value);
    int size();
    void connect(E a, E b, double weight);
    boolean connected(E a, E b);
    //it will return the weight of that edge
    double weight(E a, E b);
   
}