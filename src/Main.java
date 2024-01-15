import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my algorithm (DAA Bonus), please input your graphs " +
                "vertices seperated by commas (ex: 1,3,6,2):\n");
        String vertexInput = scanner.nextLine();
        ArrayList<Vertex> vertices = new ArrayList<>();
        try {
            String[] vertexIDs = vertexInput.split(",");
            for (String id : vertexIDs) {
                vertices.add(new Vertex(Integer.parseInt(id)));
            }
        } catch (Exception e) {
            System.out.println("Something did not work, please try again...");
            System.exit(-1);
        }

        System.out.println("Perfect, please input your edges now (ex: 1,3;6,1;1,2):\n");
        String edgeInput = scanner.nextLine();
        ArrayList<Edge> edges = new ArrayList<>();
        try {
            String[] edgeIDs = edgeInput.split(";");
            for (String tuple : edgeIDs) {
                String[] tmp = tuple.split(",");
                edges.add(new Edge(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
            }
        } catch (Exception e) {
            System.out.println("Something did not work, please try again...");
            System.exit(-1);
        }

        System.out.println("Please provide the maximum degree of your graph:\n");
        String degree = scanner.nextLine();

        int grad = 0;
        try {
            grad = Integer.parseInt(degree);
        } catch (Exception e) {
            System.out.println("Something did not work, please try again...");
            System.exit(-1);
        }
        Graph graph = new Graph(grad);

        System.out.println("Now please input all your available colors as integers, same as vertices:\n");
        String colorInput = scanner.nextLine();
        ArrayList<Integer> colors = new ArrayList<>();
        try {
            String[] colorIDs = colorInput.split(",");
            for (String c : colorIDs) {
                colors.add(Integer.parseInt(c));
            }
        } catch (Exception e) {
            System.out.println("Something did not work, please try again...");
            System.exit(-1);
        }

        for (Vertex v : vertices) graph.addVertex(v);
        for (Edge e : edges) graph.addEdge(e);
        for (int c : colors) graph.addColor(c);

        graph.createColoring(3);

        System.out.println(graph.toString());
    }
}