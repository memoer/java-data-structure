package graph.shortPath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

  private Map<Character, List<Node>> graph;

  public Data() {
    this.graph = new HashMap<>();
    initialize();
  }

  private void initialize() {
    graph.put('A', Arrays.asList(new Node('B', 8), new Node('C', 1), new Node('D', 2)));
    graph.put('B', Arrays.asList());
    graph.put('C', Arrays.asList(new Node('B', 5), new Node('D', 2)));
    graph.put('D', Arrays.asList(new Node('E', 3), new Node('F', 5)));
    graph.put('E', Arrays.asList(new Node('F', 1)));
    graph.put('F', Arrays.asList(new Node('A', 5)));
  }

  public Map<Character, List<Node>> getGraph() {
    return this.graph;
  }

}
