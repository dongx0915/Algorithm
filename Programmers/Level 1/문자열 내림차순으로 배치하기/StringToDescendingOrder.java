import java.util.Arrays;
import java.util.Collections;
class Solution {
  public String solution(String s) {
      char[] charArray = s.toCharArray();
      
      Arrays.sort(charArray);
      StringBuilder str = new StringBuilder();
      for(char c : charArray) str.append(c);
      return str.reverse().toString();
  }
}
