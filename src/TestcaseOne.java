import java.util.ArrayList;

public class TestcaseOne extends Testcase {
    public static void main(String[] args) {
        // this is the testcase for the first graph (G1)
        buildVertices(new int[]{1, 2, 3, 4, 5, 6, 7});

        edges.add(new Edge(1,2));
        edges.add(new Edge(1,6));
        edges.add(new Edge(2,3));
        edges.add(new Edge(2,4));
        edges.add(new Edge(2,5));
        edges.add(new Edge(4,6));
        edges.add(new Edge(4,5));
        edges.add(new Edge(5,7));

        degree = 4;

        buildColors(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        doColoring();
    }
}
