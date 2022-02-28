package graph.panningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal3 {
  private static Map<Character, Character> parent = new HashMap<>();
  private static Map<Character, Integer> rank = new HashMap<>();

  private static char find(char u) {
    if (parent.get(u) != u) {
      parent.put(u, find(parent.get(u)));
    }
    return parent.get(u);
  }

  private static void union(char u, char v) {
    char rootU = find(u);
    char rootV = find(v);
    if (rootU == rootV) {
      return;
    }
    int rankU = rank.get(u);
    int rankV = rank.get(v);
    if (rankU > rankV) {
      parent.put(rootV, rootU);
    } else {
      parent.put(rootU, rootV);
      if (rankU == rankV) {
        rank.put(rootV, rankV + 1);
      }
    }
  }

  public static void main(String[] args) {
    Data data = new Data();
    List<Edge> result = new ArrayList<>();
    data.sortEdgeList();

    for (char v : data.getVertices()) {
      parent.put(v, v);
      rank.put(v, 0);
    }
    for (Edge edge : data.getEdgeList()) {
      char u = edge.me;
      char v = edge.adj;
      if (find(u) != find(v)) {
        union(u, v);
        result.add(edge);
      }
    }

    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
