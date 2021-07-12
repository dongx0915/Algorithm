import java.util.Scanner;

public class Main {
    public static final int SK = 1;
    public static final int CY = -1;
    public static int[] winner;
    
    public static int dp(int n){
        if(n == 1) return winner[1] = SK;
        if(n == 2) return winner[2] = CY;
        if(n == 3) return winner[3] = SK;
        
        if(winner[n] != 0) return winner[n];
        
        return winner[n] = ((dp(n - 1) == SK) || (dp(n - 3) == SK)) ? CY : SK;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        winner = new int[n + 1];
        
        if(dp(n) == 1)System.out.println("SK");
        else System.out.println("CY");
    }
}
