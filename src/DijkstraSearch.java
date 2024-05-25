import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Set<Vertex<V>> unsettledNodes;
    private final Map<Vertex<V>, Double> distances;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<V> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex<V> neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex<V> node, Vertex<V> target) {
        for (Edge<V> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }
        throw new RuntimeException("Edge not found!");
    }

    private Vertex<V> getVertexWithMinimumWeight(Set<Vertex<V>> vertices) {
        Vertex<V> minimum = null;
        for (Vertex<V> vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(Vertex<V> destination) {
        Double d = distances.get(destination);
        return d == null ? Double.MAX_VALUE : d;
    }
}
