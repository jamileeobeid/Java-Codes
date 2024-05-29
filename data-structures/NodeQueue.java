public class NodeQueue<E> implements Queue<E>{

    //creating variables
    private Node<E> front;
    private Node<E> back;
    private int size;

    @Override
    public void enqueue(E item) {

        Node <E> newNode = new Node<E>(item);

        // adding a new node in front if it's empty
        if(front==null){
            this.front = newNode;
            this.back = newNode;
        }
        else{
            Node<E> temp = this.back;
            this.back = newNode;
            temp.setNext(newNode);
        }
        size++;
    }

    @Override
    public E dequeue() {

        E temp = this.front.getValue();
        this.front=this.front.getNext();

        if(this.front==null){
            this.back=null;
        }
        size--;

        return temp;

    }

    @Override
    public int size(){
        return size();
    }

    //creating the main method
    public static void main(String[] args) {
        
        NodeQueue <String> nq = new NodeQueue<String>();

        //creating nodes
        nq.enqueue("Node-1");
        System.out.println("Current Front Node Value: "+nq.front.getValue());
        System.out.println("Size: "+nq.size);

        nq.enqueue("Node-2");
        System.out.println("Current Front Node Value: "+nq.front.getValue());
        System.out.println("Size: "+nq.size);

        nq.enqueue("Node-3");
        System.out.println("CurrentFront Node Value: "+nq.front.getValue());
        System.out.println("Size: "+nq.size);

        System.out.println("Value dequeued: "+nq.dequeue());

        System.out.println("New Front Node Value: "+nq.front.getValue());
    }

    
}
