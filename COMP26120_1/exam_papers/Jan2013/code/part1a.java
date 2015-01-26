public class part1a {
  public static boolean hasProductPair(int[] input, int k) {
    for(int i = 0; i < input.length; i++) {
      int divResult = k / input[i];
      if(BinarySearch.binarySearch(input, divResult, i + 1, input.length - 1) >= 0) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 5, 7, 8, 10};
    System.out.println(hasProductPair(arr, 12));
    System.out.println(hasProductPair(arr, 100));
    System.out.println(hasProductPair(arr, 64));
  }
}