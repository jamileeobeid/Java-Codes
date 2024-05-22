import java.util.HashMap;
import java.util.Map;

public class WAdjacencyGraph<E> implements WGraph<E> {

    //multiple vertices with a pair of information stored in it
    private final Map<E, WVertex<E>> vertices;
    
    public WAdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
    //checks the existence of a key
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
 	//vertexname.connect(neighbor,weight)
        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);


	//example of printing the neighbors
        if(a.equals("E") && b.equals("G")) {
	//edges creates and returns set of edges (weights) in ascending order
            System.out.println(a + " = " + vertexA.edges());
            System.out.println(b + " = " + vertexB.edges());
        }

    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB) != null;
    }

    @Override
    public double weight(E a, E b) {
	//returns the weight of an edge
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }
   
    
    

}
