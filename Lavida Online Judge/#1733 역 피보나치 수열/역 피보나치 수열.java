import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long[] fibo = new long[100];

        fibo[0] = 0;
        fibo[1] = fibo[2] = 1;

        for (int i = 3; i < 100; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        
        int an = scan.nextInt();
        
        for(int i = an - 1; i >= 0; i--){
            System.out.println(fibo[i]);
        }
    }

}