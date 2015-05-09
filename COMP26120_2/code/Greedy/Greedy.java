import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Greedy {

  public static int solve(int change, TreeMap<Integer, Integer> coins) {
    while(change > 0) {
      boolean foundCoin = false;
      for(Integer coin : coins.descendingKeySet()) {
        if(coin <= change) {
          change -= coin;
          coins.put(coin, coins.get(coin) + 1);
          foundCoin = true;
          break;
        }
      }
      if(!foundCoin) {
        return change;
      }
    }
    return change;
  }
  
  public static void main(String[] args) {

    int change = Integer.parseInt(args[0]);
    TreeMap<Integer, Integer> coins = new TreeMap<Integer, Integer>();
    for(int i = 1; i < args.length; i++) {
      coins.put(Integer.parseInt(args[i]), 0);
    }

    int remaining = solve(change, coins);
    System.out.println(remaining + " remaining!");
    System.out.println("Used coins: ");
    for(Entry<Integer, Integer> e : coins.entrySet()) {
      System.out.printf("%d - %d\n", e.getKey(), e.getValue());
    }
  }

}