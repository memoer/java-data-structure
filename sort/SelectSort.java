package sort;

import util.SortTemplate;

public class SelectSort {
  public static void main(String[] args) {
    SortTemplate st = (dataList) -> {
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
    };
    st.run();
  }
}
