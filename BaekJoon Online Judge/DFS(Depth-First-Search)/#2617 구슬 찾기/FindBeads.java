import java.util.ArrayList;
import java.util.Scanner;

class Node{
    int index_;
    int heavybeads_ = 0;
    int lightbeads_ = 0;

    public Node(int index_) {
        this.index_ = index_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N, M;
    public static Node[] beads;
    public static ArrayList<Integer>[] adj, rev_adj;
    public static boolean[] visited;
    
    public static void dfs(int root, int now){
        visited[now] = true;
        for (Integer next : adj[now]) {
            if(visited[next]) continue;
            visited[next] = true;
            beads[next].heavybeads_++;
            
            dfs(root, next);
        }
    }

    public static void rev_dfs(int root, int now){
        visited[now] = true;
        for (Integer next : rev_adj[now]) {   
            if(visited[next]) continue;
            visited[next] = true;
            beads[next].lightbeads_++;
            
            rev_dfs(root, next);
        }
    }
        
    public static int getNotMiddleBeads(){
        int notMiddleBeads = 0;
        
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(i,i);
            visited = new boolean[N + 1];
            rev_dfs(i,i);
        }

        for (int i = 1; i < N + 1; i++) {
            int heavy = beads[i].heavybeads_;
            int light = beads[i].lightbeads_;
            
            //if(((N + 1) / 2) <= (heavy + light)) if(heavy != light) notMiddleBeads++;
            int mid = N >> 1;
            if(heavy > mid || light > mid) notMiddleBeads++;
        }
        
        return notMiddleBeads;
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       //구슬의 개수
        M = sc.nextInt();       //비교 쌍의 개수

        adj = new ArrayList[N + 1];
        rev_adj = new ArrayList[N + 1];
        
        beads = new Node[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 0; i < N + 1; i++){
            adj[i] = new ArrayList<>();
            rev_adj[i] = new ArrayList<>();
            beads[i] = new Node(i);
        }
        
        for (int i = 0; i < M; i++) {
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            
            adj[b1].add(b2);
            rev_adj[b2].add(b1);
        }
        
        System.out.println(getNotMiddleBeads());
    }
    
}
