import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private HashMap<Integer, Vertex> vertices = new HashMap<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList<>();
    private final int degree;

    public Graph(int degree) {
        this.degree = degree;
    }

    public void addColor(int color) {
        colors.add(color);
    }

    public ArrayList<Integer> getColors() {
        return colors;
    }

    public int addVertex(Vertex vertex) {
        vertices.put(vertex.getID(), vertex);
        return vertex.getID();
    }

    public int addEdge(Edge edge) {
        Vertex u = vertices.get(edge.u());
        Vertex v = vertices.get(edge.v());
        if (u == null || v == null) {
            return -1;
        }
        u.addConnection(v.getID());
        v.addConnection(u.getID());
        edges.add(edge);
        return 0;
    }

    public int getDegree() {
        return degree;
    }

    private ArrayList<Integer> getNeighborColors(int id) {
        ArrayList<Integer> result = new ArrayList<>();
        Vertex vertex = vertices.get(id);
        for (int neighbor : vertex.getConnections()) {
            int color = vertices.get(neighbor).getPermanentColor();
            if (color != -1) result.add(color);
        }
        return result;
    }

    private ArrayList<Integer> getNeighborCandidates(int id) {
        ArrayList<Integer> result = new ArrayList<>();
        Vertex vertex = vertices.get(id);
        for (int neighbor : vertex.getConnections()) {
            int color = vertices.get(neighbor).getCandidateColor();
            if (color != -1) result.add(color);
        }
        return result;
    }

    private ArrayList<Integer> getAvailableColors(ArrayList<Integer> neighbors) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int c : colors) {
            if (!neighbors.contains(c)) result.add(c);
        }
        return result;
    }

    private int getRandomColor(ArrayList<Integer> colors) {
        return colors.get((int) (Math.random() * colors.size()));
    }

    public int createColoring(int iterations) {
        for (int k = 0; k < iterations; k++) {
            for (Map.Entry<Integer, Vertex> v : vertices.entrySet()) {
                ArrayList<Integer> neighbors = getNeighborColors(v.getKey());
                ArrayList<Integer> available = getAvailableColors(neighbors);  // all colors minus neighbor colors
                int color = getRandomColor(available);  // select a random color out of the available ones
                v.getValue().setCandidateColor(color);
            }
            // here the colors get "exchanged"
            for (Map.Entry<Integer, Vertex> v : vertices.entrySet()) {
                if (!getNeighborColors(v.getKey()).contains(v.getValue().getCandidateColor())) {  // check if any neighbor selected the same color
                    v.getValue().setPermanentColor(v.getValue().getCandidateColor());  // permanently color this node
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String result = "G = (V, E)\nV = {";
        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            result += entry.getValue().getID() + ", ";
        }
        result = result.replaceAll(", $", "}");
        result += "\n";
        for (Edge edge : edges) {
            result += "(" + edge.u() + "," + edge.v() + ")";
        }
        result = result.replaceAll(", $", "}");
        result += "\n\nColoring:\n";

        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            result += entry.getValue().getID() + ": " + entry.getValue().getPermanentColor() + "\n";
        }

        return result;
    }
}
