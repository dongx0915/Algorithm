import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        
        for(int i = 0; i < test; i++){
            int min,max, p,q,r,s;
            min = scan.nextInt();
            max = scan.nextInt();
            p = scan.nextInt();
            q = scan.nextInt();
            r = scan.nextInt();
            s = scan.nextInt();
            
            if(min > max){
                int temp = min;
                min = max;
                max = temp;
            }
            
            int sum = 0;
            for(int j = min; j <= max; j++){
                if(j % 2 == 0) sum += j;                
            }
            if(sum == 0) System.out.println("Yes");
            else if((sum % p == 0) && (sum % q == 0) && (sum % r == 0) && (sum % s == 0)) System.out.println("Yes");
            else System.out.println("No");
        }
    }   
}