public interface Queue<E> {

    //creating enqueue abstract method
    public abstract void enqueue(E item);

    //creating dequeue method
    public abstract E dequeue();

    //creating size method
    public abstract int size();

}
