package search;

import java.util.Arrays;

public class BinarySearch {
  public static int search(int[] dataList, int search) {
    int findIdx = -1;
    int start = 0;
    int end = dataList.length - 1;
    Arrays.sort(dataList);
    while (start <= end) {
      int mid = (start + end) / 2;
      if (search < dataList[mid]) {
        end = mid - 1;
      } else if (search > dataList[mid]) {
        start = mid + 1;
      } else {
        findIdx = mid;
        break;
      }
    }
    return findIdx;
  }

  public static void main(String[] args) {
    int[] dataList = { 69, 65, 18, 71, 11, 10, 56, 52, 66, 89 };
    System.out.println(search(dataList, 66));
  }
}
