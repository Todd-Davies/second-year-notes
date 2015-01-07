import java.util.Arrays;
import java.util.*;

public class BinarySearch {
  public static int binarySearch(int[] input, int item) {
    return binarySearch(input, item, 0, input.length - 1);
  }

  public static int binarySearch(int[] input, int item,
                                 int start, int end) {
    if(start > end) return -1;
    else {
      int middleIndex = (start + end) / 2;
      if(item == input[middleIndex]) {
        return middleIndex;
      } else if(item < input[middleIndex]) {
        return binarySearch(input, item, start, middleIndex - 1);
      } else {
        return binarySearch(input, item, middleIndex + 1, end);
      }
    }
  }
}