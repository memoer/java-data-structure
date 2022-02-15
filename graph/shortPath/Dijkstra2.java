package graph.shortPath;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra2 {
  public static void main(String[] args) {
    final char START_NODE = 'A';
    Data data = new Data();
    Map<Character, Integer> path = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>();

    for (char node : data.getGraph().keySet()) {
      if (node == START_NODE) {
        path.put(node, 0);
      } else {
        path.put(node, Integer.MAX_VALUE);
      }
    }
    pq.offer(new Node(START_NODE, 0));
    while (!pq.isEmpty()) {
      Node curNode = pq.poll();
      for (Node adjNode : data.getGraph().get(curNode.name)) {
        int sum = path.get(curNode.name) + adjNode.weight;
        if (sum < path.get(adjNode.name)) {
          pq.offer(adjNode);
          path.put(adjNode.name, sum);
        }
      }
    }

    for (char node : path.keySet()) {
      System.out.println(node + " -> " + path.get(node));
    }
  }
}
