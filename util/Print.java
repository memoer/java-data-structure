package util;

public class Print {
  private Print() {
  }

  public static void out(int[] dataList) {
    for (int data : dataList) {
      System.out.print(data + ", ");
    }
    System.out.println();
  }
}
