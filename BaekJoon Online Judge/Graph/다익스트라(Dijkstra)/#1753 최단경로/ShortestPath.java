import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Node o){
        return this.distance - o.distance;
    }
}

public class Main {
    public static final int INF = 1000000000;
    public static ArrayList<Node>[] adj;
    public static int[] dis;
    
    public static void dijkstra(int start){
        int vortex = dis.length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[start] = 0;
        pq.add(new Node(start, dis[start]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.distance > dis[cur.index]) continue;
            
            for (Node next : adj[cur.index]) {
                if(dis[next.index] > dis[cur.index] + next.distance){
                    dis[next.index] = dis[cur.index] + next.distance;
                    pq.add(new Node(next.index, dis[next.index]));
                }
            }
        }
        
        for (long di : dis) {
            if(di == INF) System.out.println("INF");
            else System.out.println(di);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();   //vorter
        int e = sc.nextInt();   //edge
        int start = sc.nextInt() - 1;
        
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();
        dis = new int[v];
        
        Arrays.fill(dis, INF);
        
        for (int i = 0; i < e; i++) adj[sc.nextInt() - 1].add(new Node(sc.nextInt() - 1, sc.nextInt()));
        dijkstra(start);
    }  
}
