package graph.shortPath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;

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
    Map<Character, Integer> path = getWeightMap(graph.keySet());
    PriorityQueue<Node> pq = getQueue(graph);
    while (!pq.isEmpty()) {
      for (Entry<Character, Integer> v : path.entrySet()) {
        System.out.print("(" + v.getKey() + ", " + v.getValue() + "), ");
      }
      System.out.println();
      for (Object node : pq.stream().sorted((pre, cur) -> pre.weight - cur.weight).toArray()) {
        System.out.print(node + ", ");
      }
      System.out.println();
      System.out.println("------");
      char curName = pq.remove().name;
      for (Node adjNode : graph.get(curName)) {
        int sum = path.get(curName) + adjNode.weight;
        if (sum < path.get(adjNode.name)) {
          pq.add(new Node(adjNode.name, sum));
          path.put(adjNode.name, sum);
        }
      }
    }
    Print.out(path);
  }
}
