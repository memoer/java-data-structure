package graph.panningTree;

import java.util.*;

public class Prim5 {
  public static void main(String[] args) {
    char start_node = 'A';
    Data data = new Data();
    Edge[] edgeList = data.getEdgeList();
    List<Edge> result = new ArrayList<>();

    Set<Character> visited = new HashSet<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    for (Edge edge : edgeList) {
      // 간선 수만큼 반복 -> E
      if (edge.me == start_node) {
        pq.offer(edge);
      }
    }

    visited.add(start_node);
    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      if (visited.contains(cur.adj)) {
        continue;
      }
      result.add(cur);
      visited.add(cur.adj);
      for (Edge edge : edgeList) {
        // 간선 수만큼 반복 -> E
        if (cur.adj == edge.me && !visited.contains(edge.adj)) {
          //
          pq.offer(edge);
        }
      }
    }

    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
