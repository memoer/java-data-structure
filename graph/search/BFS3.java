package graph.search;

import java.util.*;

public class BFS3 {
  public static void main(String[] args) {
    char start_node = 'A';
    Map<Character, char[]> map = new Data().getGraph();
    List<Character> result = new ArrayList<>();

    Queue<Character> q = new LinkedList<>();
    Set<Character> visited = new HashSet<>();
    q.offer(start_node);
    visited.add(start_node);
    while (!q.isEmpty()) {
      char cur = q.poll();
      result.add(cur);
      for (char adj : map.get(cur)) {
        if (!visited.contains(adj)) {
          q.offer(adj);
        }
      }
    }
    for (Character character : result) {
      System.out.print(character +", ");
    }
    System.out.println();
  }
}
