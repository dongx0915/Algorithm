//굳이 이렇게 풀 필요는 없었지만 정답이긴함

import java.util.*;

public class Main {
    public static long getMinimumCost(Deque<Integer> dq, int sum){
        long result = 0;
        
        while(!dq.isEmpty()){
            int left = dq.peekFirst();
            int right = dq.peekLast();
            long cut = left > right ? dq.pollLast() : dq.pollFirst();
            
            result += cut * (sum -= cut);
        }
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            dq.offer(num);
            sum += num;
        }

        System.out.println(getMinimumCost(dq, sum));
    }
}
