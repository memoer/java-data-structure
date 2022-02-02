package sort;

import util.Algorithm;

/**
 * 1. 0~9 중 가장 작은 숫자 탐색 -> 해당 숫자를 0으로
 * 2. 1~9 중 가장 작은 숫자 탐색 -> 해당 숫자를 1로
 * 3. 2~9 중 가장 작은 숫자 탐색 -> 해당 숫자를 2로
 */
public class SelectSort {
  public static void main(String[] args) {
    Algorithm.job((dataList) -> {
      int length = dataList.length;
      for (int i = 0; i < length - 1; i++) {
        int temp = dataList[i];
        int[] target = { dataList[i], i };
        for (int j = i + 1; j < length; j++) {
          if (target[0] > dataList[j]) {
            target[0] = dataList[j];
            target[1] = j;
          }
        }
        if (target[1] != i) {
          dataList[i] = target[0];
          dataList[target[1]] = temp;
        }
      }
    }).run();
  }
}
