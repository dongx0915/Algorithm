import java.util.Scanner;

class Pair{
    int x_;
    int y_;

    public Pair(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[][] map;
    public static boolean[][] visited;
    public static String answer = "Hing";
    
    public static boolean isWithInRange(Pair pair, int n){
        return !(pair.x_ < 0 || pair.y_ < 0 || pair.x_ >= n || pair.y_ >= n);
    }
    
    public static void dfs(Pair root, int n){
        if(map[root.x_][root.y_] == -1){
            answer = "HaruHaru";
            return;
        }
        
        int jump = map[root.x_][root.y_];
        
        Pair[] next = {
            new Pair(root.x_, root.y_ + jump),  //오른쪽으로 점프
            new Pair(root.x_ + jump, root.y_)   //아래쪽으로 점프
        };
        
        for (int i = 0; i < 2; i++) {
            if(!isWithInRange(next[i], n)) continue;
            if(visited[next[i].x_][next[i].y_]) continue;
            
            visited[next[i].x_][next[i].y_] = true;
            dfs(next[i], n);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                map[i][j] = sc.nextInt();
        
        visited[0][0] = true;
        dfs(new Pair(0,0), n);
        
        System.out.println(answer);
    }
}
