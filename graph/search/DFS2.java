package graph.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFS2 {

  public static void main(String[] args) {
    final char START_cur = 'A';
    Map<Character, char[]> map = new Data().getGraph();
    Stack<Character> stack = new Stack<>();
    List<Character> visited = new ArrayList<>();
    stack.push(START_cur);

    while (!stack.isEmpty()) {
      char cur = stack.pop();
      visited.add(cur);
      for (char adj : map.get(cur)) {
        if (visited.contains(adj)) {
          continue;
        }
        stack.push(adj);
      }
    }

    for (char node : visited) {
      System.out.print(node + ", ");
    }
    System.out.println();
  }
}
