package util;

import java.util.Random;

public class RandomList {
  public static final int DEFAULT_LENGTH = 10;

  private RandomList() {
  }

  private static boolean isDuplicated(int[] list, int number) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] == 0) {
        break;
      } else if (list[i] == number) {
        return true;
      }
    }
    return false;
  }

  public static int[] get() {
    return get(RandomList.DEFAULT_LENGTH);
  }

  public static int[] get(int length) {
    int[] list = new int[length];
    int idx = 0;
    while (idx < length) {
      int number = new Random().nextInt(100);
      if (!isDuplicated(list, number)) {
        list[idx] = number;
        idx += 1;
      }
    }
    return list;
  }
}
