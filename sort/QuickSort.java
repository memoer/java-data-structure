package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import util.Print;
import util.RandomList;

public class QuickSort {
  private static boolean isAscending = true;

  public static List<Integer> sort(List<Integer> dataList) {
    if (dataList.size() < 2) {
      return dataList;
    }
    int mid = dataList.size() / 2;
    int pivot = dataList.get(mid);
    List<Integer> l = new ArrayList<>();
    List<Integer> r = new ArrayList<>();
    dataList.set(mid, -1);
    for (int num : dataList) {
      if (num == -1) {
        continue;
      }
      if (num < pivot) {
        l.add(num);
      } else {
        r.add(num);
      }
    }
    l = sort(l);
    l.add(pivot);
    r = sort(r);
    l.addAll(r);
    return l;
  }

  public static void main(String[] args) {
    int[] dataList = RandomList.get();
    List<Integer> sorted = sort(Arrays.stream(dataList).boxed().collect(Collectors.toList()));
    Print.out(dataList);
    Print.out(sorted);
  }
}
