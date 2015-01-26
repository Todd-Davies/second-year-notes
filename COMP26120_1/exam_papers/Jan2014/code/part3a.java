import java.util.Arrays;

public class part3a {

  public static char[] shift(char[] input, int shiftNum) {
    char[] firstHalf = Arrays.copyOfRange(input, 0, shiftNum);
    char[] secondHalf = Arrays.copyOfRange(input, shiftNum, input.length);
    for(int i = 0; i < (input.length - shiftNum); i++) {
      input[i] = secondHalf[i];
    }
    for(int i = (input.length - shiftNum); i < input.length; i++) {
      input[i] = firstHalf[i - (input.length - shiftNum)];
    }
    return input;
  }

  public static void main(String[] args) {
    char[] arr = {'a','b','c','d','e','f','g'};
    System.out.println(shift(arr, 3));
  }
}
