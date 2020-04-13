class Solution {
    public String solution(String s) {
        int cnt = 0;
        int length = s.length();
        StringBuilder str = new StringBuilder(s.toLowerCase());
        
        for(int i = 0; i < length; i++, cnt++){
            if(str.charAt(i) == ' ') cnt = -1;
            else if(cnt % 2 == 0) str.setCharAt(i, (char)(str.charAt(i) - 32));
        }
        return str.toString();
    }
}
