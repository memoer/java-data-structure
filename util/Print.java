package util;

import java.util.List;

public class Print {
  private Print() {
  }

  public static void out(int[] dataList) {
    for (int data : dataList) {
      System.out.print(data + ", ");
    }
    System.out.println();
  }

  public static void out(List<Integer> dataList) {
    for (int data : dataList) {
      System.out.print(data + ", ");
    }
    System.out.println();
  }
}
