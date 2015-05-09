public class Easy {
  public static void main(String[] args) {
    int[] input = new int[args.length];
    for(int i = 0; i < args.length; i++) {
      input[i] = Integer.parseInt(args[i]);
    }
    int min = input[0], max = input[0];
    for(int i : input) {
      if(i < min) min = i;
      if(i > max) max = i;
    }
    System.out.printf("Largest = %d\nSmallest = %d\n", max, min);
  }
}