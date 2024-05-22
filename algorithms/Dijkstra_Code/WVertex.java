package W6_Deneme;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WVertex<E> {
    //each vertex has a weight
    private E value;
    //each vertex will have a list of neighbors where each of them has a name and weight (edge)
    //its value can’t be modified so its final. But not static because each vertex will have different neighbor list but once its assigned they wont be changed. (its its static all classes should have the same value which we dont want now)
    private final Map<WVertex<E>, Edge<E>> neighbors;    

    public WVertex(E value) {
        //creates a vertex with empty list of neighbors (neighbor,edge)
        this.value = value;
        neighbors = new HashMap<>();
    }

    public E getValue() {
        return value;
    }

    public void connect(WVertex<E> neighbor, double weight) {
        //when a vertex connects to a neighbor,a new edge will be created with a weight
        Edge<E> edge = new Edge<>(this, neighbor, weight);
        //also a new record will be added to the map
        neighbors.put(neighbor, edge);
    }   

    //this method will create set of edges (weights) in ascending order
    public Set<Edge<E>> edges() {
        Set<Edge<E>> edges = new TreeSet<>();
        //keyset brings unique keys in a map 
        for(WVertex<E> neighbor : neighbors.keySet()) {
            //get method brings weights for a given key
            edges.add(neighbors.get(neighbor));
        }
        return edges;
    }

    //tihs will return the edge (with weight) for a given vertex(neighbor)
    public Edge<E> edge(WVertex<E> neighbor) {
        return neighbors.get(neighbor);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}


