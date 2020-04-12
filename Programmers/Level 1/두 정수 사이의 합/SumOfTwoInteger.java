class Solution {
  public long solution(long a, long b) {
        return (a < b) ? ((a+b) * (b - a + 1)) / 2  : ((a + b) * (a - b + 1)) / 2; 
  }
}
