package graph.shortPath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra3 {
  public static void main(String[] args) {
    final char START_NODE = 'A';
    PriorityQueue<Node> pq = new PriorityQueue<>();
    Map<Character, List<Node>> map = new Data().getGraph();
    Map<Character, Integer> path = new HashMap<>();
    for (char node : map.keySet()) {
      path.put(node, Integer.MAX_VALUE);
    }
    path.put(START_NODE, 0);
    pq.offer(new Node(START_NODE, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (cur.weight > path.get(cur.name)) {
        continue;
      }
      for (Node adj : map.get(cur.name)) {
        int sum = cur.weight + adj.weight;
        if (sum < path.get(adj.name)) {
          path.put(adj.name, sum);
          pq.offer(new Node(adj.name, sum));
        }
      }
    }
    for (char node : path.keySet()) {
      System.out.println(node + " -> " + path.get(node));
    }
  }
}
