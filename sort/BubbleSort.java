package sort;

import util.Algorithm;

public class BubbleSort {
  public static void swap(boolean isAscending, int[] dataList, int i, int j) {
    int a = dataList[i];
    int b = dataList[j];
    if (isAscending) {
      if (a > b) {
        dataList[i] = b;
        dataList[j] = a;
      }
    } else if (a < b) {
      dataList[i] = b;
      dataList[j] = a;
    }
  }

  public static void main(String[] args) {
    Algorithm.job(dataList -> {
      int dataListLength = dataList.length;
      for (int i = 0; i < dataListLength - 1; i++) {
        for (int j = 0; j < dataListLength - i - 1; j++) {
          swap(true, dataList, j, j + 1);
        }
      }
    }).run();
  }

}
