import java.util.*;

public class Main{
    public static int getCompareCnt(int n, PriorityQueue<Integer> card){
        int result = 0;
        
        while(card.size() > 1){
            int n1 = card.poll();
            int n2 = card.poll();
            
            result += (n1 + n2);
            card.add((n1 + n2));
        }
        return result;    
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) pq.add(sc.nextInt());
        System.out.println(getCompareCnt(n, pq));
    }
}
