package graph.search;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Stack;

import util.Graph;
import util.Print;

// DFS는 Stack 을 사용
public class DFS {

  public static Stack<Character> getStack(char startNode) {
    Stack<Character> s = new Stack<>();
    s.push(startNode);
    return s;
  }

  public static void dfs(Map<Character, char[]> graph, char startNode) {
    Stack<Character> s = getStack(startNode);
    List<Character> visitedNodeList = new ArrayList<>();

    while (!s.isEmpty()) {
      char curNode = s.pop();
      visitedNodeList.add(curNode);
      for (char adjacentNode : graph.get(curNode)) {
        if (visitedNodeList.contains(adjacentNode)) {
          continue;
        }
        s.push(adjacentNode);
      }
    }

    // 확인용
    Print.out(visitedNodeList);
  }

  public static void main(String[] args) {
    Map<Character, char[]> graph = new Graph().getGraph();
    dfs(graph, 'A');
  }
}
