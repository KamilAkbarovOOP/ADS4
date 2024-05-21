import java.util.*;
public class Vertex<V>{
    private V data;
    private Map<Vertex <V>, Double> adjucentVertices;

    public void addAdjacentVertex(Vertex<V> dest, double weight){
        adjucentVertices.put(dest, weight);
    }

    public Vertex (V data){
        this.data = data;
        this.adjucentVertices = new HashMap<>();
    }

    public void setData(){
        this.data = data;
    }
    public V getData(){
        return data;
    }

    public Map<Vertex<V>, Double> getAdjucentVertices(){
        return adjucentVertices;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

}