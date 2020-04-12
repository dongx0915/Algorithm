import java.util.ArrayList;
import java.util.Arrays;

class Solution {
        public int[] solution(int[] arr, int divisor) {
            ArrayList<Integer> Answers = new ArrayList<>();

            for(int s : arr)  if(s % divisor == 0) Answers.add(s);
            if(Answers.isEmpty()) Answers.add(-1);
            
            int size = Answers.size();
            int[] answer = new int[size];
            
            for(int i = 0; i < size; i++) answer[i] = Answers.get(i);
            
            Arrays.sort(answer);
            
            return answer;
        }
}
