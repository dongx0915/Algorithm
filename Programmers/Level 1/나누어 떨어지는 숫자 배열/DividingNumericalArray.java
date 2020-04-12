class Solution {
  public int[] solution(int[] arr, int divisor) {
        return Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray(); // 람다식을 이용해 divisor로 나눠지는 배열의 원소를 
  }
}
