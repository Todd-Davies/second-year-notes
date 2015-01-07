import java.util.HashMap;

public class part1b {
  public static boolean hasMajorityElement(int[] input) {
    HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
    final int desiredCount = (input.length / 2) + 1;
    for(int i : input) {
      if(!count.containsKey(i)) count.put(i, 0);
      int c = count.get(i);
      if(++c == desiredCount) return true;
      else count.put(i, c);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 5, 7, 8, 10};
    System.out.println(hasMajorityElement(arr));
    int[] arr2 = {2, 3};
    System.out.println(hasMajorityElement(arr2));
    int[] arr3 = {2, 3, 2, 5, 2, 8, 2};
    System.out.println(hasMajorityElement(arr3));
  }
}