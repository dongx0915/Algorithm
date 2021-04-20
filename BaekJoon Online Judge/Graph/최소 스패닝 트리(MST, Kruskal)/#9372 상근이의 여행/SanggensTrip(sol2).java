import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int n = sc.nextInt();       //국가의 수
            int m = sc.nextInt();       //비행기 종류
            
            for (int i = 0; i < m; i++) {
                 sc.nextInt();
                 sc.nextInt();
            }
            
            System.out.println(n - 1);
        }
    }
}
