import java.util.ArrayList;

public class Testcase {
    protected static ArrayList<Vertex> vertices = new ArrayList<>();
    protected static ArrayList<Edge> edges = new ArrayList<>();
    protected static ArrayList<Integer> colors = new ArrayList<>();
    protected static int degree = 0;

    protected static void doColoring() {
        System.out.println(Main.calculateColoring(vertices, edges, colors, degree));
    }

    protected static void buildVertices(int[] verts) {
        for (int v : verts) {
            vertices.add(new Vertex(v));
        }
    }

    protected static void buildColors(int[] cols) {
        for (int c : cols) {
            colors.add(c);
        }
    }
}
