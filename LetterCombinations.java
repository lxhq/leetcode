import java.util.*;

public class LetterCombinations {
  public List<String> letterCombinations(String digits) {
    LinkedList<String> result = new LinkedList<>();
    if (digits.isEmpty()) return result;
    String[] set = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxzy"};
    result.add("");
    while(result.peek().length() != digits.length()) {
      String remove = result.remove();
      String map = set[digits.charAt(remove.length()) - '0'];
      for(char c : map.toCharArray()) {
        result.addLast(remove + c);
      }
    }
    return result;
  }

  public static void main(String[] stra){
    LetterCombinations a = new LetterCombinations();
    System.out.println(a.letterCombinations("234"));
  }
}
