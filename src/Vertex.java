import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private String data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(String data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public String getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<V> vertex = (Vertex<V>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return data;
    }
}
