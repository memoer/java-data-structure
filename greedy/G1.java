package greedy;

public class G1 {
  public static void main(String[] args) {
    System.out.println(fibo(10));
  }

  public static int fibo(int num) {
    int[] cache = { 0, 1, 1, 2, 3 };
    int cacheLength = cache.length;
    if (num < cacheLength) {
      return cache[num];
    }
    int a = cache[cacheLength - 2];
    int b = cache[cacheLength - 1];
    for (int i = cacheLength; i < num; i++) {
      int temp = a;
      a = b;
      b = temp + b;
    }
    return a + b;
  }
}
