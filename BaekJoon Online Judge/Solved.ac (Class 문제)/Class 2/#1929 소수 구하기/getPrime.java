import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i+=2) if(n % i == 0) return false;
        
        return true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        for (int i = M; i <= N; i++) if(isPrime(i)) System.out.println(i);
    }
}
