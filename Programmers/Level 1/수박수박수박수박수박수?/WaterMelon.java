class Solution {
        public String solution(int n) {
            String[] waterMelon = {"수", "박"};
            String answer = "";
            
            for(int i = 0; i < n; i++){
                answer += waterMelon[i % 2]; // 문자열의 길이에 따라 "수", "박"을 차례대로 하나 씩 추가
            }
            return answer;
        }
}
