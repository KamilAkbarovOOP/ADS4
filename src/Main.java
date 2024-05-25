public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");
        Search<String> dijkstraSearch = new DijkstraSearch<>(weightedGraph, almaty);
        outputPath(dijkstraSearch, kyzylorda);

        System.out.println("--------------------------------");

        MyGraph<String> unweightedGraph = new MyGraph<>(true);
        fillWithoutWeights(unweightedGraph);


        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(unweightedGraph, almaty);
        outputPath(bfs, kyzylorda);
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> atyrau = new Vertex<>("Atyrau");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addEdge(almaty, astana);
        graph.addEdge(shymkent, atyrau);
        graph.addEdge(atyrau, astana);
        graph.addEdge(almaty, shymkent);
        graph.addEdge(shymkent, astana);
        graph.addEdge(astana, kostanay);
        graph.addEdge(shymkent, kyzylorda);
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> atyrau = new Vertex<>("Atyrau");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addEdge(almaty, astana, 2.1);
        graph.addEdge(shymkent, atyrau, 7.8);
        graph.addEdge(atyrau, astana, 7.1);
        graph.addEdge(almaty, shymkent, 7.2);
        graph.addEdge(shymkent, astana, 3.9);
        graph.addEdge(astana, kostanay, 3.5);
        graph.addEdge(shymkent, kyzylorda, 5.4);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        Iterable<Vertex<String>> path = search.pathTo(key);
        if (path == null) {
            System.out.println("No path found");
        } else {
            for (Vertex<String> v : path) {
                System.out.print(v + " -> ");
            }
            System.out.println();
        }
    }
}
