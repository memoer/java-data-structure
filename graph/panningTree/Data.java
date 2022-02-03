package graph.panningTree;

import java.util.Arrays;

public class Data {
  private char[] vertices;
  private Edge[] edgeList;

  public Data() {
    this.vertices = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
    this.edgeList = new Edge[] {
        new Edge(7, 'A', 'B'),
        new Edge(5, 'A', 'D'),
        new Edge(7, 'B', 'A'),
        new Edge(8, 'B', 'C'),
        new Edge(9, 'B', 'D'),
        new Edge(7, 'B', 'E'),
        new Edge(8, 'C', 'B'),
        new Edge(5, 'C', 'E'),
        new Edge(5, 'D', 'A'),
        new Edge(9, 'D', 'B'),
        new Edge(7, 'D', 'E'),
        new Edge(6, 'D', 'F'),
        new Edge(7, 'E', 'B'),
        new Edge(5, 'E', 'C'),
        new Edge(7, 'E', 'D'),
        new Edge(8, 'E', 'F'),
        new Edge(9, 'E', 'G'),
        new Edge(6, 'F', 'D'),
        new Edge(8, 'F', 'E'),
        new Edge(11, 'F', 'G'),
        new Edge(9, 'G', 'E'),
        new Edge(11, 'G', 'F')
    };
  }

  public void sortEdgeList() {
    Arrays.sort(edgeList);
  }

  public char[] getVertices() {
    return vertices;
  }

  public Edge[] getEdgeList() {
    return edgeList;
  }

}
