class Solution {
  int LIMIT = 1000001;
    boolean[] PrimeCheck = new boolean[LIMIT]; // 소수 체크 결과를 저장할 

    public void prime_init() {
        PrimeCheck[0] = PrimeCheck[1] = true;
        int sqrtLimit = (int)Math.sqrt((double)LIMIT);
        
        for(int i = 2; i <= sqrtLimit; i++){  //에라토스테네스체를 사용하여 소수 체크
            if(!PrimeCheck[i]){
                for(int j = i * i; j < LIMIT; j = j + i){
                    PrimeCheck[j] = true;
                }
            }
        }
    }

    public int solution(int n) {
        int answer = 0;
        prime_init();
        
        for(int i = 1; i <= n; i++){
            if(PrimeCheck[i] == false) answer++;
        }
        
        return answer;
    }

}
