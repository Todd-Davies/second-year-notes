import java.util.Arrays;

public class MergeSort {

  private static int[] mergeSort(int[] input) {
    return mergeSort(input, 0, input.length - 1);
  }

  private static int[] mergeSort(int[] input, int start, int end) {
    if((end - start) == 0) {
      return Arrays.copyOfRange(input, start, end + 1);
    } else {
      int middle = start + ((end - start) / 2);
      int[] firstHalf = mergeSort(input, start, middle);
      int[] secondHalf = mergeSort(input, middle + 1, end);
      int[] output = new int[firstHalf.length + secondHalf.length];
      int l = 0, r = 0, o = 0;
      while(l < firstHalf.length || r < secondHalf.length) {
        if(l < firstHalf.length && r < secondHalf.length)  {
          if(firstHalf[l] < secondHalf[r]) {
            output[o++] = firstHalf[l++];
          } else {
            output[o++] = secondHalf[r++];
          }  
        } else if(l < firstHalf.length) {
          output[o++] = firstHalf[l++];
        } else {
          output[o++] = secondHalf[r++];
        }
      }
      return output;
    }
  }

  public static void main(String[] args) {
    int[] toSort = {10,9,8,7,6,5,4,3,2,1,0};
    System.out.println(Arrays.toString(toSort));
    int[] sorted = mergeSort(toSort);
    System.out.println(Arrays.toString(sorted));
  }
}