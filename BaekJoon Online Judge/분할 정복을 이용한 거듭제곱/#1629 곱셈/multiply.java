import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static long square(int n1, int n2, int div){
        if(n2 == 1) return n1 % div;
        
        long temp = square(n1, n2 / 2, div);
        
        temp = (temp * temp) % div;
        
        // n2가 홀수인 경우 n1을 한번 더 곱해줌
        // A^5 일 때는 A^2와 A^2로 나눠지므로 밑에서 계산 된 결과 값이 A^4로 올라옴
        // 따라서, A를 한 번 더 곱해줘야 함
        
        if(n2 % 2 == 1) return (temp * n1) % div;
        else return temp;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int div = sc.nextInt();
           
        System.out.println(square(n1, n2, div));
    }
}
