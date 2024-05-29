public class Node <E> {

    //creating variables
    private E value;
    private Node <E> next; //They type of next is Node <E>

    //creating a Node (this is override)
    public Node(E value){
        this.value = value;
    }

    //creating a Node (this is overload)
    public Node(E value, Node <E> next){
        this.value = value;
        this.next = next;
    }

    //creating getters and setters
    public E getValue(){
        return value;
    }

    public void setValue(E value){
        this.value = value;
    }

    public Node <E> getNext(){
        return next;
    }

    public void setNext(Node <E> next){
        this.next = next;
    }

    public static void main(String[] args) {

        //creating 3 nodes (instances)
        Node <String> node1 = new Node <String> ("Node 1");
        Node <String> node3 = new Node <String> ("Node 3");
        Node <String> node2 = new Node <String> ("Node 2", node3); //linking node2 and node3

        node1.setNext(node2); //another way of linking nodes

        //printing our nodes
        System.out.println("Queue\n1. "+node1.getValue()+
        "\n2. "+node1.getNext().getValue()+
        "\n3. "+node2.getNext().getValue());
    } 
}
