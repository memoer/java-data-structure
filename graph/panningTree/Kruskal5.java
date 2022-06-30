package graph.panningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal5 {
  private static final Map<Character, Character> parent = new HashMap<>();
  private static final Map<Character, Integer> rank = new HashMap<>();

  private static char find(char v) {
    if (v != parent.get(v)) {
      parent.put(v, find(parent.get(v)));
    }
    return parent.get(v);
  }

  private static void union(char rootV, char rootU) {
    int rankV = rank.get(rootV);
    int rankU = rank.get(rootU);
    if (rankV > rankU) {
      parent.put(rootU, rootV);
    } else {
      parent.put(rootV, rootU);
      if (rankV == rankU) {
        rank.put(rootU, rank.get(rootU) + 1);
      }
    }
  }

  public static void main(String[] args) {
    Data data = new Data();
    Edge[] edgeArr = data.getEdgeList();
    List<Edge> result = new ArrayList<>();
    for (char v : data.getVertices()) {
      parent.put(v, v);
      rank.put(v, 0);
    }
    data.sortEdgeList();
    for (Edge edge : edgeArr) {
      char rootV = find(edge.me);
      char rootU = find(edge.adj);
      if (rootV != rootU) {
        union(rootV, rootU);
        result.add(edge);
      }
    }

    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
