class Solution {
    public int solution(int n) {
            int sum = 0, i;
        for(i = 1; i * i < n; i++){ // 약수의 성질을 이용 ( 제곱근보다 큰 약수까지는 for문을 돌릴 필요가 없음)
            if(n % i == 0) sum += i + (n / i);
        }
        
        if(i * i == n) sum += i; (제곱수인경우는 위의  for문에서 포함되지 않으므로 마지막에 더해줘야함)
        return sum;
    }
}
