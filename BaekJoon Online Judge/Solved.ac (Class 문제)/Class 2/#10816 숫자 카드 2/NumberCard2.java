import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        Hashtable<Integer, Integer> num = new Hashtable<>();
        
        for (int i = 0; i < N; i++) {
            int next = sc.nextInt();
            num.put(next, num.getOrDefault(next, 0) + 1);
        }
        
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) sb.append(num.getOrDefault(sc.nextInt(), 0)).append(" ");
        
        System.out.println(sb.toString());
    }
}
