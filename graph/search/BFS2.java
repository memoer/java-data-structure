package graph.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS2 {

  public static void main(String[] args) {
    final char START_cur = 'A';
    Map<Character, char[]> map = new Data().getGraph();

    Queue<Character> q = new LinkedList<>();
    List<Character> visited = new ArrayList<>();
    q.offer(START_cur);

    while (!q.isEmpty()) {
      char cur = q.poll();
      visited.add(cur);
      for (char adj : map.get(cur)) {
        if (visited.contains(adj)) {
          continue;
        }
        q.offer(adj);
      }
    }

    for (char node : visited) {
      System.out.print(node + ", ");
    }
    System.out.println();
  }
}
