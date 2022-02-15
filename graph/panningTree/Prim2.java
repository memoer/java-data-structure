package graph.panningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim2 {
  public static void main(String[] args) {
    final char START_NODE = 'A';
    Data data = new Data();
    Set<Character> visited = new HashSet<>();
    List<Edge> result = new ArrayList<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>();

    visited.add(START_NODE);
    for (Edge edge : data.getEdgeList()) {
      if (edge.me == START_NODE) {
        pq.offer(edge);
      }
    }

    while (!pq.isEmpty()) {
      Edge curEdge = pq.poll();
      if (visited.contains(curEdge.adj)) {
        continue;
      }
      visited.add(curEdge.adj);
      result.add(curEdge);
      for (Edge adjEdge : data.getEdgeList()) {
        if (visited.contains(adjEdge.adj)) {
          continue;
        }
        if (curEdge.adj == adjEdge.me) {
          pq.offer(adjEdge);
        }
      }
    }

    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
