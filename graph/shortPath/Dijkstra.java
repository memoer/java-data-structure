package graph.shortPath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import util.Print;

public class Dijkstra {
  public static final char START_NODE = 'A';

  public static PriorityQueue<Node> getQueue(Map<Character, List<Node>> graph) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(START_NODE, 0));
    return pq;
  }

  public static Map<Character, Integer> getWeightMap(Set<Character> keySet) {
    Map<Character, Integer> result = new HashMap<>();
    for (char key : keySet) {
      if (key == START_NODE) {
        result.put(key, 0);
      } else {
        result.put(key, Integer.MAX_VALUE);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Map<Character, List<Node>> graph = new Data().getGraph();
    Map<Character, Integer> distances = getWeightMap(graph.keySet());
    PriorityQueue<Node> pq = getQueue(graph);
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (distances.get(cur.name) < cur.weight) {
        continue;
      }
      for (Node adjNode : graph.get(cur.name)) {
        int sum = cur.weight + adjNode.weight;
        if (sum < distances.get(adjNode.name)) {
          distances.put(adjNode.name, sum);
          pq.add(new Node(adjNode.name, sum));
        }
      }
    }
    Print.out(distances);
  }
}
