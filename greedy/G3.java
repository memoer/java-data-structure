package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G3 {

  public static void main(String[] args) {
    int[][] dataList = { { 10, 10 }, { 15, 12 }, { 20, 10 }, { 25, 8 }, { 30, 5 } };
    List<String[]> details = new ArrayList<>();
    float totalValue = 0;
    int capacity = 30;

    Arrays.sort(dataList, (pre, cur) -> {
      float a = (float) pre[1] / pre[0];
      float b = (float) cur[1] / cur[0];
      return Float.compare(b, a);
    });

    for (int[] data : dataList) {
      if (capacity == 0) {
        break;
      }
      int weight = data[0];
      int value = data[1];
      float valuePerWeight = (float) data[1] / data[0];
      if (weight <= capacity) {
        totalValue += value;
        capacity -= weight;
        details.add(new String[] { String.valueOf(weight), String.valueOf(value) });
      } else if (capacity > 0) {
        totalValue += valuePerWeight * capacity;
        details.add(new String[] { String.valueOf(capacity), String.valueOf(valuePerWeight * capacity) });
        capacity = 0;
      }
    }

    System.out.println("totalValue -> " + totalValue);
    for (String[] data : details) {
      System.out.print("weight -> " + data[0] + " / value -> " + data[1]);
      System.out.println();
    }
  }
}
