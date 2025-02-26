package graph;


public class Edge {
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return this.source;
    }

    public int getDestination() {
        return this.destination;
    }
}