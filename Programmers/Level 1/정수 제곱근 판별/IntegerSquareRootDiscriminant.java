class Solution {
  public long solution(long n) {
      long answer = 0;
      double x = Math.sqrt(n);
      int div_x = (int)x;
      
      return (x - div_x == 0) ? (long)Math.pow(div_x + 1, 2) : -1;
  }
}
