import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int idx_;
    int dis_;

    public Edge(int index_, int dis_) {
        this.idx_ = index_;
        this.dis_ = dis_;
    }
    @Override
    public int compareTo(Edge e){
        return this.dis_ - e.dis_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 50000001;
    public static int[] dijkstra(ArrayList<Edge>[] graph, int V, int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dis = new int[V + 1];
        Arrays.fill(dis, INF);
        
        dis[start] = 0;
        pq.add(new Edge(start, dis[start]));
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            for (Edge next : graph[cur.idx_]) {
                if(dis[next.idx_] > dis[cur.idx_] + next.dis_){
                    dis[next.idx_] = dis[cur.idx_] + next.dis_;
                    pq.offer(new Edge(next.idx_, dis[next.idx_]));
                }
            }
        }
        return dis;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();       //정점의 개수
        int E = sc.nextInt();       //간선의 개수
        int P = sc.nextInt();       //건우 위치
        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        
        for (int i = 0; i < V + 1; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < E; i++) {
            //n1 -> n2 = dis
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int d = sc.nextInt();
            
            graph[n1].add(new Edge(n2, d));
            graph[n2].add(new Edge(n1, d));
        
        }
        int[] dis = dijkstra(graph, V, 1);
        int[] p_dis = dijkstra(graph, V, P);
        
        if((dis[P] + p_dis[V]) == dis[V]) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }
}
