package graph.shortPath;

public class Node implements Comparable<Node> {
  char name;
  int weight;

  public Node(char name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node o) {
    return this.weight - o.weight;
  }

  @Override
  public String toString() {
    return "(name: " + name + ", weight: " + weight + ")";
  }
}