package util;

import java.util.List;
import java.util.Map;

public class Print {
  private Print() {
  }

  public static void out(int[] dataList) {
    for (int data : dataList) {
      System.out.print(data + ", ");
    }
    System.out.println();
  }

  public static <T> void out(List<T> dataList) {
    for (T data : dataList) {
      System.out.print(data + ", ");
    }
    System.out.println();
  }

  public static <T, S> void out(Map<T, S> map) {
    for (T key : map.keySet()) {
      System.out.print("key -> " + key + " / " + "value -> " + map.get(key));
      System.out.println();
    }
  }

}
