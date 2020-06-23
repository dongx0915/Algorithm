import java.util.*;

public class Main {
    public static void JoshepoosSeq(int n, int delete, Queue<Integer> queue){
        System.out.print("<");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < delete - 1; j++) {
                queue.offer(queue.poll());
            }   
            if(queue.size() == 1) System.out.println(queue.poll() + ">");        
            else System.out.print(queue.poll() + ", ");
        }

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int delete = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        JoshepoosSeq(n, delete, queue);
    }
}
