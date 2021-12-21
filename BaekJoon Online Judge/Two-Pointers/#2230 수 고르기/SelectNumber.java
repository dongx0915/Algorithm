import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int solution(int N, int M, int[] num){
        int s = 0, e = 0;
        int minRange = Integer.MAX_VALUE;
        
        int range = 0;
        while(s < N && e < N){
            range = num[e] - num[s];
            if(range == M) return M;
            
            if(range < M) e++;
            else{
                minRange = Math.min(minRange, range);
                s++;
            }
        }
        
        return minRange;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] array = new int[N];
        
        for (int i = 0; i < N; i++) array[i] = sc.nextInt();
        Arrays.sort(array);
        
        System.out.println(solution(N, M, array));
    }
}
