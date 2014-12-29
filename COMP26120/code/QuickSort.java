import java.util.Arrays;
import java.util.*;

public class QuickSort {


  private static <T extends Comparable<T>> void swap(T[] list, int i1,
                                                     int i2) {
    T temp = list[i1];
    list[i1] = list[i2];
    list[i2] = temp;
  }

  public static <T extends Comparable<T>> void quickSort(T[] list) {
    quickSort(list, 0, list.length - 1);
  }

  public static <T extends Comparable<T>> void quickSort(T[] list, int start,
                                                         int end) {
    if(start >= end) {
     return; // 0 or 1 elements
    } else {
      int midPoint = start + ((end - start) / 2);
      T pivot = list[midPoint];
      int swapIndex = start;
      swap(list, midPoint, end);
      for(int i = start; i < end; i++) {
        if(pivot.compareTo(list[i]) > 0) {
          swap(list, i, swapIndex++);
        }
      }
      swap(list, end, swapIndex);
      quickSort(list, start, swapIndex - 1);
      quickSort(list, swapIndex + 1, end);
    }
  }


  public static void main(String[] args) {
    Integer[] testData = {4,3,2,6,7,56,4,3,7,8,6,4,23,56,6,4,23,2,2,1,6,5,34,8};
    System.out.println(Arrays.toString(testData));
    quickSort(testData);
    System.out.println(Arrays.toString(testData));
  }

}