package structureNPattern.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// BFS는 Queue 을 사용함
public class BFS {
  static class Solution {
    private Map<Character, char[]> graph;

    public void init(char startNode, List<Character> answer, Queue<Character> q) {
      graph = new HashMap<Character, char[]>();
      graph.put('A', new char[] { 'B', 'C' });
      graph.put('B', new char[] { 'D' });
      graph.put('D', new char[] { 'E', 'F' });
      graph.put('E', new char[] {});
      graph.put('F', new char[] {});
      graph.put('C', new char[] { 'G', 'H', 'I' });
      graph.put('G', new char[] {});
      graph.put('H', new char[] {});
      graph.put('I', new char[] { 'J' });
      graph.put('J', new char[] {});
      q.add(startNode);
    }

    public List<Character> solution(char startNode) {
      List<Character> answer = new ArrayList<>();
      Queue<Character> q = new LinkedList<>();
      init(startNode, answer, q);
      while (!q.isEmpty()) {
        char node = q.poll();
        answer.add(node);
        for (char adjNode : graph.get(node)) {
          q.add(adjNode);
        }
      }
      return answer;
    }
  }

  public static void main(String[] args) throws Exception {
    for (char c : new Solution().solution('A')) {
      System.out.print(c + ", ");
    }
  }
}
