package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import util.Print;

public class NQueen {
  public static List<int[]> result = new ArrayList<>();

  public static boolean isAvailable(int targetRow, int targetCol, int[] candidate) {
    for (int row = 0; row < targetRow; row++) {
      int col = candidate[row];
      int diffRow = Math.abs(targetRow - row);
      int diffCol = Math.abs(targetCol - col);
      if (targetCol == col || diffCol == diffRow) {
        return false;
      }
    }
    return true;
  }

  public static void solveNQueens(int row, int n, int[] candidate) {
    if (row == n) {
      result.add(Arrays.copyOfRange(candidate, 0, n));
      return;
    }
    for (int col = 0; col < n; col++) {
      if (isAvailable(row, col, candidate)) {
        candidate[row] = col;
        solveNQueens(row + 1, n, candidate);
        candidate[row] = 0;
      }
    }
  }

  public static void main(String[] args) {
    int n = 4;
    solveNQueens(0, n, new int[n]);
    for (int[] array : result) {
      for (int num : array) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}
