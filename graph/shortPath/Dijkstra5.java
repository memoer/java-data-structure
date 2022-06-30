package graph.shortPath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra5 {
  public static void main(String[] args) {
    char start_node = 'A';
    Map<Character, List<Node>> graph = new Data().getGraph();
    Map<Character, Integer> distance = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>();

    initDistance(start_node, graph, distance);
    pq.offer(new Node(start_node, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (cur.weight > distance.get(cur.name)) {
        continue;
      }
      for (Node adj : graph.get(cur.name)) {
        int sum = distance.get(cur.name) + adj.weight;
        if (sum < distance.get(adj.name)) {
          distance.put(adj.name, sum);
          pq.offer(new Node(adj.name, sum));
        }
      }
    }

    for (Map.Entry<Character, Integer> entry : distance.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  private static void initDistance(char start_node, Map<Character, List<graph.shortPath.Node>> map, Map<Character,
          Integer> distance) {
    for (char node : map.keySet()) {
      if (node == start_node) {
        distance.put(node, 0);
      } else {
        distance.put(node, Integer.MAX_VALUE);
      }
    }
  }
}
