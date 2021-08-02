import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static final long INF = (400 * 399 * 10000) + 1; // V * E * dis
    public static int V,E;
    public static long[][] road;

    public static void floyd(){
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if(j == i || k == i || j == k) continue;
                    road[j][k] = Math.min(road[j][k], road[j][i] + road[i][k]);
                }
            }
        }
    }
    
    public static long bfs(int root){
        Queue<Integer> q = new LinkedList<>();
        Queue<Long> dis_q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        long min = Integer.MAX_VALUE;
        
        q.offer(root);
        dis_q.offer((long)0);
        visited[root] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            long cur_dis = dis_q.poll();
            
            for (int i = 0; i < V; i++) {
                //연결되지 않았거나 이미 방문헀으면 continue;
                if(road[cur][i] == INF) continue;
                if(visited[i]){
                    if(i == root) min = Math.min(min, (cur_dis + road[cur][i]));
                    else continue;
                }
                
                q.offer(i);
                dis_q.offer(cur_dis + road[cur][i]);
                visited[i] = true;
            }
        }
        
        return min;
    }
    
    public static long getRoutine(){
        long min = Integer.MAX_VALUE;
        
        for (int i = 0; i < V; i++) min = Math.min(min, bfs(i));
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        road = new long[V][V];
        
        for (int i = 0; i < V; i++) Arrays.fill(road[i], INF);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            road[n1][n2] = Integer.parseInt(st.nextToken());
        }

        floyd();
        System.out.println(getRoutine());
    }
}
