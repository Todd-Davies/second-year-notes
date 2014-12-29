import java.util.BitSet;
import java.util.ArrayList;

public class part2a {
  public static ArrayList<Integer> intersect(int[] input, int[] input2) {
    BitSet bs = new BitSet(input.length);
    for(int i : input) bs.set(i);
    ArrayList<Integer> intersection = new ArrayList<Integer>();
    for(int i : input2) if(bs.get(i)) intersection.add(i);
    return intersection;
  }

  public static void main(String[] args) {
    int[] arr = {2,5,3,8,2,4,7};
    int[] arr2 = {6,7,2,4,9,1};
    for(int i : intersect(arr, arr2)) {
      System.out.println(i);
    }
  }
}