class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_cnt = 0, y_cnt = 0;
        int length = s.length();
        s = s.toLowerCase();
        
        for(int i = 0; i < length; i++){
            char ch = s.charAt(i);
            if(ch == 'p') p_cnt++;
            else if(ch == 'y') y_cnt++;
        }

        return (p_cnt == y_cnt) ? true :false;
    }
}
