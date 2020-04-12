import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        int length = arr.length;
        int overlap = 0;
        
        for(int i = 0; i < length - 1; i++){
            if(arr[i] == arr[i+1]){ // 현재 숫자와 다음 숫자가 같으면 현재 숫자를 -1로 변경
                arr[i] = -1;
                overlap++; 
            }
        }
        int[] answer = new int[length - overlap];
        int index = 0;
        
        for(int j = 0; j < length; j++){
            if(arr[j] != -1) answer[index++] = arr[j];
        }
        return answer;
	}
}
