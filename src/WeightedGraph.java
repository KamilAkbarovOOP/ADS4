import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<Vertex<V>, List<Edge<V>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<V> v) {
        if (hasVertex(v))
            return;
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);
        if (!hasVertex(dest))
            addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest))
            return;
        map.get(source).add(new Edge<>(source, dest, weight));
        if (undirected)
            map.get(dest).add(new Edge<>(dest, source, weight));
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> v : map.keySet()) {
            count += map.get(v).size();
        }
        if (undirected)
            count /= 2;
        return count;
    }

    public boolean hasVertex(Vertex<V> v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(new Edge<>(source, dest, null));
    }

    public List<Vertex<V>> adjacencyList(Vertex<V> v) {
        if (!hasVertex(v)) return Collections.emptyList();
        List<Vertex<V>> vertices = new LinkedList<>();
        for (Edge<V> e : map.get(v)) {
            vertices.add(e.getDest());
        }
        return vertices;
    }

    public Iterable<Edge<V>> getEdges(Vertex<V> v) {
        if (!hasVertex(v)) return Collections.emptyList();
        return map.get(v);
    }
}
