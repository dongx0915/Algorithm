import java.util.ArrayList;

class Solution {
     public int[] solution(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int s : arr) {
            if (min > s) {
                min = s;
            }
            arrList.add(s);
        }

        arrList.remove((Integer)min);
        if(arrList.isEmpty()) arrList.add(-1);
        int size = arrList.size();
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++){
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}
