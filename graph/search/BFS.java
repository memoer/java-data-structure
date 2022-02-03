package graph.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import util.Print;

// BFS는 Queue 을 사용함
public class BFS {
  public static Queue<Character> getQueue(char startNode) {
    Queue<Character> q = new LinkedList<>();
    q.add(startNode);
    return q;
  }

  public static void bfs(Map<Character, char[]> graph, char startNode) {
    Queue<Character> q = getQueue(startNode);
    List<Character> visitedNodeList = new ArrayList<>();

    while (!q.isEmpty()) {
      char curNode = q.remove();
      visitedNodeList.add(curNode);
      for (char adjacentNode : graph.get(curNode)) {
        if (visitedNodeList.contains(adjacentNode)) {
          continue;
        }
        q.add(adjacentNode);
      }
    }

    Print.out(visitedNodeList);
  }

  public static void main(String[] args) throws Exception {
    Map<Character, char[]> graph = new Data().getGraph();
    bfs(graph, 'A');
  }
}
