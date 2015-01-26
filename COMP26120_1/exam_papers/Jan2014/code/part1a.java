public class part1a {
  public static boolean hasSum(int[] input, int sum) {
    for(int i = 0; i < input.length; i++) {
      for(int j = 0; j <= i; j++) {
        if((input[i] + input[j]) == sum) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {2, 10, 5, 3, 7, 4, 8};
    System.out.println(hasSum(arr, 17));
  }
}