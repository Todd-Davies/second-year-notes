import java.util.Arrays;
import java.util.*;

public class BinarySearch {


  public static <T extends Comparable<T>> int binarySearch(T[] input, T item) {
    return binarySearch(input, item, 0, input.length);
  }

  public static <T extends Comparable<T>> int binarySearch(T[] input, T item,
                                                           int start, int end) {
    if(start > end) return -1;
    else {
      int middleIndex = start + ((end - start) / 2);
      int comparison = item.compareTo(input[middleIndex]);
      if(comparison == 0) {
        return middleIndex;
      } else if(comparison < 0) {
        return binarySearch(input, item, start, middleIndex - 1);
      } else {
        return binarySearch(input, item, middleIndex + 1, end);
      }
    }
  }


  public static void main(String[] args) {
    Integer[] testData = {1,1,3,5,6,6,7,9,10,14,14,23,25,32,40,90};
    System.out.println(Arrays.toString(testData));
    System.out.printf("Searching for %d: %d\n", 5, binarySearch(testData, 5));
    System.out.printf("Searching for %d: %d\n", 1, binarySearch(testData, 1));
    System.out.printf("Searching for %d: %d\n", 32, binarySearch(testData, 32));
    System.out.printf("Searching for %d: %d\n", 11, binarySearch(testData, 11));
  }

}