package graph.panningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim3 {
  public static void main(String[] args) {
    final char START_NODE = 'A';
    Set<Character> visited = new HashSet<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    List<Edge> result = new ArrayList<>();
    Data data = new Data();

    visited.add(START_NODE);
    for (Edge edge : data.getEdgeList()) {
      if (edge.me == START_NODE) {
        pq.offer(edge);
      }
    }
    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      if (visited.contains(cur.adj)) {
        continue;
      }
      visited.add(cur.adj);
      result.add(cur);
      for (Edge edge : data.getEdgeList()) {
        if (visited.contains(edge.adj)) {
          continue;
        }
        if (cur.adj == edge.me) {
          pq.offer(edge);
        }
      }
    }
    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
