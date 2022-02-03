package graph.panningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal {
  static private class Inner {
    private Map<Character, Character> parent = new HashMap<>();
    private Map<Character, Integer> rank = new HashMap<>();
    private List<Edge> result = new ArrayList<>();
    private Data data;

    public Inner(Data data) {
      this.data = data;
      data.sortEdgeList();
      for (char v : data.getVertices()) {
        parent.put(v, v);
        rank.put(v, 0);
      }
    }

    private char find(char node) {
      if (parent.get(node) != node) {
        parent.put(node, find(parent.get(node)));
      }
      return parent.get(node);
    }

    private void union(char nodeA, char nodeB) {
      char rootA = find(nodeA);
      char rootB = find(nodeB);
      if (rank.get(rootA) > rank.get(rootB)) {
        parent.put(rootB, rootA);
      } else {
        parent.put(rootA, rootB);
        if (rank.get(rootA) == rank.get(rootB)) {
          rank.put(rootB, rank.get(rootB) + 1);
        }
      }
    }

    public List<Edge> run() {
      for (Edge edge : this.data.getEdgeList()) {
        char nodeA = edge.me;
        char nodeB = edge.adj;
        if (find(nodeA) != find(nodeB)) {
          union(nodeA, nodeB);
          result.add(edge);
        }
      }
      return result;
    }
  }

  public static void main(String[] args) {
    List<Edge> result = new Inner(new Data()).run();
    for (Edge e : result) {
      System.out.println(e);
    }
  }
}
