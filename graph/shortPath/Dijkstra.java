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
    Map<Character, Integer> weightMap = getWeightMap(graph.keySet());
    PriorityQueue<Node> pq = getQueue(graph);
    while (!pq.isEmpty()) {
      char curName = pq.remove().name;
      for (Node adjacentNode : graph.get(curName)) {
        char adjName = adjacentNode.name;
        int sumWeight = weightMap.get(curName) + adjacentNode.weight;
        if (sumWeight < weightMap.get(adjName)) {
          pq.add(adjacentNode);
          weightMap.put(adjName, sumWeight);
        }
      }
    }

    Print.out(weightMap);
  }
}
