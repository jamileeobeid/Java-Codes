@SuppressWarnings("rawtypes")
public class ArrayQueue implements Queue{

    private int size;
    private int back = -1;
    private int front = -1;
    private String[] elements = new String[5];

    @Override
    public void enqueue(Object item){

        //Full
        if((back + 1) % elements.length == front){
            System.out.println("Queue is Full\n");
        }

        //Empty
        else if(front == -1){
            front = 0;
            back = 0;
            elements[back] = (String) item;
            size ++;
        }
        
        else{
            back = (back + 1) % elements.length;
            elements[back] = (String) item;
            size ++;
        }
    }

    @Override
    public String dequeue(){
        
        String temp;
        if(front == -1) //Empty
        {
            System.out.println("Queue is Empty\n");
            return "Empty Stack";
        }

        //One Element
        else if (front == back){
            temp = elements[front];
            front = -1;
            back = -1;
            size --;
            return temp;
        }
        else{
            temp = elements[front];
            front = (front + 1) % elements.length;
            size --;
            return temp;
        }

    }

    @Override
    public int size(){
        return size;
    }

    public String getFrontValue() {
        return elements[front];
    }

    public int getFront(){
        return front;
    }

    public static void main(String[] args) {
        
        ArrayQueue nq = new ArrayQueue();

        nq.enqueue("Node 1");
        System.out.println("Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() + "\nSize: " + nq.size);

        nq.enqueue("Node 2");
        System.out.println("Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() + "\nSize: " + nq.size);

        nq.enqueue("Node 3");
        System.out.println("Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() + "\nSize: " + nq.size);

        nq.enqueue("Node 4");
        System.out.println("Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() + "\nSize: " + nq.size);

        nq.enqueue("Node 5");
        System.out.println("Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() + "\nSize: " + nq.size);

        nq.enqueue("Node 6");

        String temp = nq.dequeue();
        System.out.println("Dequeued: " + temp + ", Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() +"\nSize: " + nq.size);

        temp = nq.dequeue();
        System.out.println("Dequeued: " + temp + ", Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() +"\nSize: " + nq.size);

        nq.enqueue("Node 6");
        System.out.println("Dequeued: " + temp + ", Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() +"\nSize: " + nq.size);

        temp = nq.dequeue();
        System.out.println("Dequeued: " + temp + ", Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() +"\nSize: " + nq.size);

        temp = nq.dequeue();
        System.out.println("Dequeued: " + temp + ", Node Value: " + nq.getFrontValue() + ", Node Front Index: " + nq.getFront() +"\nSize: " + nq.size);

        temp = nq.dequeue();
        System.out.println("Dequeued: " + temp + "\nSize: " + nq.size);

        temp = nq.dequeue();
        System.out.println("Dequeued: " + temp + "\nSize: " + nq.size);

        temp = nq.dequeue();
        System.out.println("Dequeued: " + temp + "\nSize: " + nq.size);
    }

}
