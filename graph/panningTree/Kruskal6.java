package graph.panningTree;


import java.util.*;

public class Kruskal6 {
  private static Map<Character, Character> parent = new HashMap<>();
  private static Map<Character, Integer> rank = new HashMap<>();

  private static char find(char node) {
    if (node != parent.get(node)) {
      parent.put(node, find(parent.get(node)));
    }
    return parent.get(node);
  }

  private static void union(char parentU, char parentV) {
    int rankU = rank.get(parentU);
    int rankV = rank.get(parentV);
    // rank를 사용하지 않을 경우, 최악의 경우 linkedlist가 되버린다.
    // union-by-rank 기법을 통해 트리구조 형태로 만들면, 시간복잡도는 logN이 된다.
    if (rankU > rankV) {
      parent.put(parentV, parentU);
    } else {
      parent.put(parentU, parentV);
      if (rankU == rankV
      ) {
        rank.put(parentV, rankV + 1);
      }
    }
  }
  public static void main(String[] args) {
    Data data = new Data();
    // 첫 번째 시간복잡도
    // 1. 퀵정렬 사용시, 시간복잡도 NlogN
    // 2. 간선의 수만큼 정렬하는 거기 떄문에, ElogE가 된다.
    data.sortEdgeList();
    Edge[] edgeArr = data.getEdgeList();
    Set<Character> vertices = data.getVertices();
    List<Edge> result = new ArrayList<>();

    // 두 번째 시간 복잡도
    // 1. 초기화 과정에서 각 노드만큼 반복문이 돌아간다 -> O(V)
    for (char vertex : vertices) {
      parent.put(vertex, vertex);
      rank.put(vertex, 1);
    }

    for (Edge edge : edgeArr) {
      // 세 번째 시간복잡도
      // 1. 간선의 수만큼 반복 E
      // 2. union-by-rank + path-compression 기법 사용시 시간복잡도는 O(1)에 가깝다.
      // 3. 합치는 곳에서의 시간 복잡도는 결국엔 O(E)가 된다.
      char parentU = find(edge.me);
      char parentV = find(edge.adj);
      if (parentU != parentV) {
        union(parentU, parentV);
        result.add(edge);
      }
    }
    // 즉, 크루스칼의 총 시간 복잡도는 O(ElogE + V + E)가 된다.
    // 1. 시간 복잡도는 이 중에서, 가장 높은 수를 선택한다.
    // 2. 간선의 수와 노드 수에서는 보통 간선의 수가 항상 크다 -> O(ElogE + E) [ 노드 수 제거 ]
    // 3. E보단 ElogE의 수가 더 크다 -> O(ElogE)
    // 4. 즉, 크루스칼의 시간 복잡도는 ElogE가 된다.
    for (Edge edge: result) {
      System.out.println(edge);
    }
  }
}
