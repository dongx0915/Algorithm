import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        int[] fibo = new int[100];
        
        fibo[0] = 0;
        fibo[1] = fibo[2] = 1;
        
        for(int i = 3; i < 100; i++){
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        for(int i = 0; i < test; i++){
           System.out.println(fibo[scan.nextInt()]);  
        }
    }

}