package graph.panningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal2 {
  private static Map<Character, Character> parent = new HashMap<>();
  private static Map<Character, Integer> rank = new HashMap<>();

  private static char find(char node) {
    if (node != parent.get(node)) {
      parent.put(node, find(parent.get(node)));
    }
    return parent.get(node);
  }

  private static void union(char rootA, char rootB) {
    int rankA = rank.get(rootA);
    int rankB = rank.get(rootB);
    if (rankA > rankB) {
      parent.put(rootB, rootA);
    } else {
      parent.put(rootA, rootB);
      if (rankA != rankB) {
        rank.put(rootB, rankB + 1);
      }
    }
  }

  public static void main(String[] args) {
    Data data = new Data();
    List<Edge> result = new ArrayList<>();

    data.sortEdgeList();
    for (char node : data.getVertices()) {
      parent.put(node, node);
      rank.put(node, 0);
    }

    for (Edge edge : data.getEdgeList()) {
      char rootA = find(edge.me);
      char rootB = find(edge.adj);
      if (rootA != rootB) {
        union(rootA, rootB);
        result.add(edge);
      }
    }

    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
