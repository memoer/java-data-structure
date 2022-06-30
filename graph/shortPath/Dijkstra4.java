package graph.shortPath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra4 {
  public static void main(String[] args) {
    final char START_NODE = 'A';
    PriorityQueue<Node> pq = new PriorityQueue<>();
    Map<Character, List<Node>> map = new Data().getGraph();
    Map<Character, Integer> path = new HashMap<>();
    for (char node : map.keySet()) {
      if (node == START_NODE) {
        path.put(node, 0);
      } else {
        path.put(node, Integer.MAX_VALUE);
      }
    }
    pq.offer(new Node(START_NODE, 0));
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (cur.weight > path.get(cur.name)) {
        continue;
      }
      for (Node adj : map.get(cur.name)) {
        int adjWeight = cur.weight + adj.weight;
        if (path.get(adj.name) > adjWeight) {
          path.put(adj.name, adjWeight);
          pq.offer(new Node(adj.name, adjWeight));
        }
      }
    }
    for (Map.Entry<Character, Integer> entry : path.entrySet()) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
  }

}

