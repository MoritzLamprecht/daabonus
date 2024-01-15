import java.util.ArrayList;

public class Vertex {
    private int id;
    private ArrayList<Integer> connections = new ArrayList<>();
    private int permanentColor = -1;
    private int candidateColor = -1;

    public Vertex(int id) {
        this.id = id;
    }

    public void addConnection(int id) {
        connections.add(id);
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }

    public void setPermanentColor(int color) {
        this.permanentColor = color;
    }

    public void setCandidateColor(int color) {
        this.candidateColor = color;
    }

    public int getPermanentColor() {
        return permanentColor;
    }

    public int getCandidateColor() {
        return candidateColor;
    }

    public int getID() {
        return id;
    }
}
