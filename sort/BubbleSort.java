package sort;

import util.Algorithm;

/**
 * 1. 0~9까지 2개의 숫자만 비교해서 큰 숫자롤 위로 올림 -> 가장 큰 숫자가 9에 위치함
 * 2. 0~8까지 2개의 숫자만 비교해서 큰 숫자를 위로 올림 -> 가장 큰 숫자가 8에 위치함
 * 3. 0~7까지 2개의 숫자만 비교해서 큰 숫자를 위로 올림 -> 가장 큰 숫자가 7에 위치함
 */
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
