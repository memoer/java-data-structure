package graph.panningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import util.Print;

public class Prim {
  public static final char START_NODE = 'A';

  public static void main(String[] args) {
    Data data = new Data();
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    Set<Character> visitedNodeSet = new HashSet<>();
    List<Edge> result = new ArrayList<>();

    visitedNodeSet.add(START_NODE);
    for (Edge edge : data.getEdgeList()) {
      if (edge.me == START_NODE) {
        pq.add(edge);
      }
    }

    while (!pq.isEmpty()) {
      Edge polledEdge = pq.poll();
      if (visitedNodeSet.contains(polledEdge.adj)) {
        continue;
      }
      visitedNodeSet.add(polledEdge.adj);
      result.add(polledEdge);
      for (Edge edge : data.getEdgeList()) {
        if (visitedNodeSet.contains(edge.adj)) {
          continue;
        }
        if (edge.me == polledEdge.adj) {
          pq.add(edge);
        }
      }
    }

    for (Edge edge : result) {
      System.out.println(edge);
    }
  }
}
