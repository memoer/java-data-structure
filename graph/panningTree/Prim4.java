package graph.panningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim4 {
  public static void main(String[] args) {
    final char START_NODE = 'A';
    Edge[] edgeList = new Data().getEdgeList();
    Set<Character> visisted = new HashSet<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    List<Edge> result = new ArrayList<>();

    for (Edge edge : edgeList) {
      if (edge.me != START_NODE) {
        continue;
      }
      pq.offer(edge);
    }
    visisted.add(START_NODE);
    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      if (visisted.contains(cur.adj)) {
        continue;
      }
      visisted.add(cur.adj);
      result.add(cur);
      for (Edge edge : edgeList) {
        if (cur.adj != edge.me || visisted.contains(edge.adj)) {
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
