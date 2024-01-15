public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        for(int i = 0; i < 20; i++) {
            graph.addColor(i);
        }
        for (int i = 0; i < 10; i++) {
            graph.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 8; i++) {
            int vertex = (int) (Math.random() * 8);
            graph.addEdge(new Edge(i, (vertex == i) ? vertex + 1 : vertex));
        }
        graph.createColoring(1);
        System.out.println(graph.toString());
    }
}