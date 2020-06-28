import java.util.Scanner;

public class Main {

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public static int getGcd(int[] brother_Dis){ 
        int length = brother_Dis.length;
        int gcd = gcd(brother_Dis[0], brother_Dis[1]);
        
        for (int i = 2; i < length; i++)  gcd = gcd(brother_Dis[i], gcd);
        return gcd;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 동생의 수
        int subin_Location = sc.nextInt(); // 수빈이의 위치
        int[] brother_Dis = new int[n];
        
        for (int i = 0; i < n; i++) brother_Dis[i] = Math.abs(subin_Location - sc.nextInt());

        if(n == 1) System.out.println(brother_Dis[0]);
        else System.out.println(getGcd(brother_Dis));
    }
}
