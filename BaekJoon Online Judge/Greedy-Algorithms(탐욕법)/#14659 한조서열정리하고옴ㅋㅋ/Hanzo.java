import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] peak = new int[n];
        
        for (int i = 0; i < n; i++) {
            peak[i] = sc.nextInt();
        }
        
        int max = 0;
        int cnt = 0;
        int prev = peak[0];
        
        for (int i = 1; i < n; i++) {
            if(prev > peak[i]) cnt++;
            else{
                max = Math.max(cnt, max);
                cnt = 0;
                prev = peak[i];
            }
        }
        
        max = Math.max(cnt, max);
        System.out.println(max);
    }
    
}
