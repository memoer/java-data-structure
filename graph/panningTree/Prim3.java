package graph.panningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim3 {
  public static void main(String[] args) {
    final char START_NODE = 'A';
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    Set<Character> visited = new HashSet<>();
    List<Edge> result = new ArrayList<>();
    Data data = new Data();

    for (Edge edge : data.getEdgeList()) {
      if (edge.me != START_NODE) {
        continue;
      }
      pq.offer(edge);
    }
    visited.add(START_NODE);

    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      result.add(cur);
      visited.add(cur.adj);
      for (Edge edge : data.getEdgeList()) {
        if (edge.me != cur.adj) {
          continue;
        }
        pq.offer(edge);
      }
    }

    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
