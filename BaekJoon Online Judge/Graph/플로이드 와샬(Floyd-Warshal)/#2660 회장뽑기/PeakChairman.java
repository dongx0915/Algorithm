import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static final int INF = 1000;
    public static int[][] friends;

    public static void floyd(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == i || k == i || j == k) continue;
                    friends[j][k] = Math.min(friends[j][k], friends[j][i] + friends[i][k]);
                }
            }
        }
    }
    
    public static String getCandidate(int n){
        class Rank implements Comparable<Rank>{
            int index_;
            int score_ = 0;
            public Rank(int i){
                this.index_ = i;
            }
            @Override
            public int compareTo(Rank r){
                if(this.score_ == r.score_) return this.index_ - r.index_;
                return this.score_ - r.score_;
            }
        }
        
        Queue<Rank> q = new LinkedList<>();
        StringJoiner result = new StringJoiner(" ");
        
        
        for (int i = 0; i < n; i++) {
            Rank r = new Rank(i + 1);
            
            for (int j = 0; j < n; j++) {
                if(friends[i][j] == INF) continue;
                r.score_ = Math.max(r.score_, friends[i][j]);
            }
            
            if(q.isEmpty()){
                q.offer(r);
                continue;
            }
            
            while(!q.isEmpty()){
                if(q.peek().score_ > r.score_) while(!q.isEmpty() && q.peek().score_ > r.score_) q.poll();
                if(q.isEmpty() || q.peek().score_ == r.score_) {
                    q.offer(r);
                    break;
                }
                else break;
            }
        }
        
        System.out.println(q.peek().score_ + " " + q.size());
        while(!q.isEmpty()) result.add(q.poll().index_ + "");
        
        return result.toString();
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        friends = new int[n][n];
        
        for (int i = 0; i < n; i++) Arrays.fill(friends[i], INF);
        for (int i = 0; i < n; i++) friends[i][i] = 0;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            if(n1 == -2 && n2 == -2) break;
            if(n1 == n2) continue;
            
            friends[n1][n2] = friends[n2][n1] = 1;
        }
        
        floyd(n);
        System.out.println(getCandidate(n));
    }
}
