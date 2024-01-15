public class TestcaseTwo extends Testcase {
    public static void main(String[] args) {
        // this is the testcase for the second graph (G2)
        buildVertices(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        edges.add(new Edge(1,2));
        edges.add(new Edge(1,6));
        edges.add(new Edge(2,3));
        edges.add(new Edge(2,5));
        edges.add(new Edge(6,7));
        edges.add(new Edge(7,5));
        edges.add(new Edge(3,5));
        edges.add(new Edge(3,4));
        edges.add(new Edge(5,4));
        edges.add(new Edge(4,9));
        edges.add(new Edge(5,8));
        edges.add(new Edge(8,9));

        degree = 5;

        buildColors(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        doColoring();
    }
}
