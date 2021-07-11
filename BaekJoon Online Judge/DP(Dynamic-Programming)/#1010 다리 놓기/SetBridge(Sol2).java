import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static BigInteger[] bigFact;
    public static void f(int n){
        bigFact[0] = bigFact[1] = BigInteger.valueOf(1);
        
        for (int i = 2; i <= n; i++) bigFact[i] = bigFact[i - 1].multiply(BigInteger.valueOf(i));
    }
    
    public static BigInteger combination(int m, int n){
        return bigFact[m].divide(bigFact[n]).divide(bigFact[m - n]);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] n = new int[test];
        int[] m = new int[test];
        int max = 0;
        
        for (int i = 0; i < test; i++) {
            n[i] = sc.nextInt();
            m[i] = sc.nextInt();
            if(max < m[i]) max = m[i];
        }
        
        bigFact = new BigInteger[max + 1];
        f(max);

        for (int i = 0; i < test; i++) System.out.println(combination(m[i], n[i]));
    }
}
