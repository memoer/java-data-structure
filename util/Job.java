package util;

@FunctionalInterface
public interface Job {
  public void main(int[] dataList);

  public default void run() {
    this.run(RandomList.DEFAULT_LENGTH);
  }

  public default void run(int size) {
    int[] dataList = RandomList.get(size);
    Print.out(dataList);
    main(dataList);
    Print.out(dataList);
  }

}
