import java.util.Scanner;

public class Main {
    
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public static long getSumOfGcd(int[] arr){
        int length = arr.length;
        long gcd_sum = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                gcd_sum += gcd(arr[i], arr[j]);
            }
        }
        return gcd_sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.println(getSumOfGcd(arr));
        }
    }    
}
