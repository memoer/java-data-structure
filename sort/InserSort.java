package sort;

import util.Algorithm;

public class InserSort {

  public static void main(String[] args) {
    boolean isAscending = true;
    Algorithm.job(dataList -> {
      int length = dataList.length;
      for (int i = 1; i < length; i++) {
        int target = dataList[i];
        int idx = 0;
        for (int j = 0; j < i; j++) {
          if (isAscending ? target < dataList[j] : target > dataList[j]) {
            break;
          }
          idx += 1;
        }
        if (i != idx) {
          for (int j = i; j > idx; j--) {
            dataList[j] = dataList[j - 1];
          }
          dataList[idx] = target;
        }
      }
    }).run();
  }
}