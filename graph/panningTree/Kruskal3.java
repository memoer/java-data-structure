package graph.panningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal3 {
  private static Map<Character, Character> parent = new HashMap<>();
  private static Map<Character, Integer> rank = new HashMap<>();

  private static char find(char a) {
    if (a != parent.get(a)) {
      parent.put(a, find(parent.get(a)));
    }
    return parent.get(a);
  }

  private static void union(char a, char b) {
    char rootA = find(a);
    char rootB = find(b);
    if (rootA == rootB) {
      return;
    }
    int rankA = rank.get(rootA);
    int rankB = rank.get(rootB);
    if (rankA > rankB) {
      parent.put(rootB, rootA);
    } else {
      parent.put(rootA, rootB);
      if (rankA == rankB) {
        rank.put(rootB, rankB + 1);
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
      if (find(edge.me) != find(edge.adj)) {
        union(edge.me, edge.adj);
        result.add(edge);
      }
    }
    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
