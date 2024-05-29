import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    
    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph(){
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }

    void addVertex(String label){
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label){

        Vertex v = new Vertex(label);

        adjVertices.values().forEach(a -> a.remove(v));
        adjVertices.remove(v);
        
    }

    void addEdge(String label1, String label2){
        
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        //creating undirectional connection
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);

    }

    void removeEdge(String label1, String label2){

        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List <Vertex> ev1 = adjVertices.get(v1);
        List <Vertex> ev2 = adjVertices.get(v2);

        if(ev1 != null){
            ev1.remove(v2);
        }
        if(ev2 != null){
            ev2.remove(v1);
        }

    }

    //taking the name of the object and returning the neighbours
    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    String printGraph(){

        //puts all the strings in one basket --> StringBuffer
        StringBuffer sb = new StringBuffer();

        for(Vertex v: adjVertices.keySet()){
            sb.append(v);
            sb.append(adjVertices); //appending the neighbours
        }

        return sb.toString(); //casting because return type is String

    }

    class Vertex {

        String label;

        //constructor for vertex class
        Vertex(String label){
        this.label = label;
        }

        @Override
        public String toString(){
        return this.label;
        }

        @Override
        public boolean equals(Object obj){

        if(this==obj){ return true; }

        if(obj==null){ return false; }

        if(this.getClass() != obj.getClass()){ return false; }

        Vertex other = (Vertex)(obj);

        if(!(getOuterType().equals(other.getOuterType()))){ return false; }

        if(label==null){
            if(other.label != null) { return false; }
        }

        else if(!(label.equals(other.label))){ return false; }

        return true; //if everything is passed, both are equal, so true
    }

        private Graph getOuterType(){ return Graph.this; }

        @Override
        public int hashCode(){

            final int prime = 31;
            int result = 1;

            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label==null) ?0 : label.hashCode()); //lambda 
            return result;
        }
    }

    public static void main(String[] args) {
        
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
    
        System.out.println(graph.printGraph());

    }
}

