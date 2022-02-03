package graph.panningTree;

public class Edge implements Comparable<Edge> {
  public int weight;
  public char me;
  public char adj;

  public Edge(int weight, char me, char adj) {
    this.weight = weight;
    this.me = me;
    this.adj = adj;
  }

  @Override
  public String toString() {
    return String.format("(%d, %c, %c)", weight, me, adj);
  }

  @Override
  public int compareTo(Edge o) {
    return this.weight - o.weight;
  }
}
