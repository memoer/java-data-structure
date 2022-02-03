package sort;

import java.util.Arrays;

import util.Algorithm;

public class MergeSort {
  public static boolean isAscending = false;

  public static int[] merge(int[] l, int[] r) {
    int[] sorted = new int[l.length + r.length];
    int lp = 0, rp = 0, idx = 0;
    while (lp < l.length && rp < r.length) {
      if (isAscending) {
        sorted[idx++] = l[lp] > r[rp] ? r[rp++] : l[lp++];
      } else {
        sorted[idx++] = l[lp] > r[rp] ? l[lp++] : r[rp++];
      }
    }
    while (idx < sorted.length) {
      if (lp < l.length) {
        sorted[idx++] = l[lp++];
      } else if (rp < r.length) {
        sorted[idx++] = r[rp++];
      }
    }
    return sorted;
  }

  public static int[] splitNMerge(int[] dataList) {
    if (dataList.length < 2) {
      return dataList;
    }
    int mid = dataList.length / 2;
    int[] l = splitNMerge(Arrays.copyOfRange(dataList, 0, mid));
    int[] r = splitNMerge(Arrays.copyOfRange(dataList, mid, dataList.length));
    return merge(l, r);
  }

  public static void main(String[] args) {
    Algorithm.job((dataList) -> {
      int[] sorted = splitNMerge(dataList);
      for (int i = 0; i < dataList.length; i++) {
        dataList[i] = sorted[i];
      }
    }).run();
  }

}
