package util;

@FunctionalInterface
public interface SortTemplate {
  public void job(int[] dataList);

  public default void run() {
    this.run(RandomList.DEFAULT_LENGTH);
  }

  public default void run(int size) {
    int[] dataList = RandomList.get(size);
    Print.out(dataList);
    job(dataList);
    Print.out(dataList);
  }
}
