import java.util.ArrayList;
class Solution {
  public int[] solution(long n) {
      ArrayList<Integer> list = new ArrayList<>();
      while(n != 0){
          list.add((int)(n % 10));
          n /= 10;
      } 
      
      int size = list.size();
      int[] answer = new int[size];
      
      for(int i = 0; i < size; i++){
          answer[i] = list.get(i);
      }
      return answer;
  }
}
