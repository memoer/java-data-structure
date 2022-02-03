package graph.search;

import java.util.HashMap;
import java.util.Map;

public class Data {
  private Map<Character, char[]> graph = new HashMap<>();

  public Data() {
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
  }

  public Map<Character, char[]> getGraph() {
    return this.graph;
  }
}
