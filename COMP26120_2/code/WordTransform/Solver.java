import java.util.LinkedList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Sorry if it's messy, this is just a prototype!
 */

public class Solver {

  public TreeSet<String> seen = new TreeSet<String>();
  Comparator<WordTree> comp;

  public Solver(String filename, String start, final String end) throws IOException {
    try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String word;
      do {
        WordTree.addWord(word = br.readLine());
      } while(word != null);
    }

    comp = new Comparator<WordTree>() {
      public int compare(WordTree w1, WordTree w2) {
        return distance(w1.value, end) - distance(w2.value, end);
      }
    };

    WordTree tree = new WordTree(start);
    LinkedList<String> s = solve(tree, end);
    while(!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }

  private LinkedList<String> solve(WordTree tree, String word) {
    LinkedList<String> result = solve(null, tree, word);
    if(result != null) result.addFirst(tree.value);
    return result;
  }

  private LinkedList<String> solve(LinkedList<String> res, WordTree tree, String word) {
    if(tree.value.equals(word)) return new LinkedList();
    if(seen.contains(tree.value)) return null;
    else {
      seen.add(tree.value);
      PriorityQueue<WordTree> queue = new PriorityQueue<WordTree>(3, comp);
      for(WordTree child : tree.getChildren()) queue.add(child);
      while(!queue.isEmpty()) {
        WordTree next = queue.poll();
        res = solve(res, next, word);
        if(res != null) {
          res.push(next.value);
          return res;
        }
      }
      seen.remove(tree.value);
    }
    return null;
  }

  private int distance(String word1, String word2) {
    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    int distance = 0;
    for(int i = 0; i < w1.length; i++) {
      if(w1[i] != w2[i]) distance++;
    }
    return distance;
  }

  public static void main(String[] args) throws IOException {
    new Solver(args[0], args[1], args[2]);
  }

}