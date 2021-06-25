import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0, cnt = 0, prev = 0;
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(prev > num) cnt++;
            else{
                max = Math.max(cnt, max);
                prev = num;
                cnt = 0;
            }
        }
        
        System.out.println(Math.max(cnt, max));
    }
}
