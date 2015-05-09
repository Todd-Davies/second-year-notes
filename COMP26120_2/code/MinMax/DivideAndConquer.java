public class DivideAndConquer {

  private static class Pair { int min, max; }

  public static Pair findMinMax(int[] input, int start, int end) {
    if((end - start) <= 1) {
      Pair output = new Pair();
      output.max = (input[start] < input[end]) ? input[end] : input[start];
      output.min = (input[start] < input[end]) ? input[start] : input[end];
      return output;
    } else {
      Pair firstHalf = findMinMax(input, start, end - ((end - start) / 2));
      Pair secondHalf = findMinMax(input, end - ((end - start) / 2), end);
      if(firstHalf.min > secondHalf.min) firstHalf.min = secondHalf.min;
      if(firstHalf.max < secondHalf.max) firstHalf.max = secondHalf.max;
      return firstHalf;
    }
  }

  public static void main(String[] args) {
    int[] input = new int[args.length];
    for(int i = 0; i < args.length; i++) {
      input[i] = Integer.parseInt(args[i]);
    }
    Pair out = findMinMax(input, 0, input.length - 1);
    System.out.printf("Largest = %d\nSmallest = %d\n", out.max, out.min);
  }
}