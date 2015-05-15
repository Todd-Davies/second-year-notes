import java.util.LinkedList;
import java.util.TreeSet;

public class WordTree {

  private static char[] chars = {'a','b','c','d','e','f',
                                 'g','h','i','j','k','l',
                                 'm','n','o','p','q','r',
                                 's','t','u','v','w','x',
                                 'y','z'};

  private static TreeSet<String> dict;
  public static void addWord(String word) { 
    if(dict == null) dict = new TreeSet<String>();
    if(word != null) dict.add(word);
  }
  
  private LinkedList<WordTree> children;
  public final String value;

  public WordTree(String word) {
    this.value = word;
  }

  public LinkedList<WordTree> getChildren() {
    if(children == null) {
      this.children = new LinkedList<WordTree>();
      StringBuilder childBuilder = new StringBuilder(value);
      for(int i = 0; i < childBuilder.length(); i++) {
        char initialChar = childBuilder.charAt(i);
        for(int j = 0; j < chars.length; j++) {
          childBuilder.setCharAt(i, chars[j]);
          String newWord = childBuilder.toString();
          if(dict.contains(newWord) && !newWord.equals(value)) {
            children.add(new WordTree(childBuilder.toString()));
          }
        }
        childBuilder.setCharAt(i, initialChar);
      }
    }
    return children;
  }
}