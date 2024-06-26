public class Edge<E> implements Comparable<Edge<E>> {
    private double weight;
    private WVertex<E> from;
    private WVertex<E> to;

    public Edge(WVertex<E> from, WVertex<E> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    public WVertex<E> getFrom() {
        return from;
    }

    public WVertex<E> getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Edge{"
            + "from=" + from.getValue()
            + ", to=" + to.getValue()
            + ", weight=" + this.weight
            + "}";
    }

    @Override
    public int compareTo(Edge<E> o) {
        // can't return 0 so use <=
        return this.weight <= o.weight ? -1 : 1;
    }
}

