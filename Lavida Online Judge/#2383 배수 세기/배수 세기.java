import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n,m, sum = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        
        sum = (m + 1) * m / 2;
        System.out.println(sum * n);
    }
}