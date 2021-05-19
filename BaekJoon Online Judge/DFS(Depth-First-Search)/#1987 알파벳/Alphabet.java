import java.util.Scanner;

class Pair{
    int x_;
    int y_;
    int cnt_;
    
    public Pair(int x_, int y_, int cnt_) {
        this.x_ = x_;
        this.y_ = y_;
        this.cnt_ = cnt_;
    }
}

public class Main {
    public static String[] board;
    public static boolean[] alpha_visited;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int r,c, max_cnt = Integer.MIN_VALUE;
    
    public static void dfs(Pair root){
        max_cnt = Math.max(root.cnt_, max_cnt);

        for (int i = 0; i < 4; i++) {
            Pair next = new Pair(root.x_ + dx[i], root.y_ + dy[i], root.cnt_ + 1);
            if(next.x_ < 0 || next.y_ < 0 || next.x_ >= r || next.y_ >= c) continue;
            
            char nextChar = board[next.x_].charAt(next.y_);
            if(!alpha_visited[nextChar - 'A'] && !visited[next.x_][next.y_]){
                alpha_visited[nextChar - 'A'] = true;
                visited[next.x_][next.y_] = true;
                
                dfs(next);
                
                alpha_visited[nextChar - 'A'] = false;
                visited[next.x_][next.y_] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        r = sc.nextInt();     //세로
        c = sc.nextInt();     //가로
        
        board = new String[r];
        alpha_visited = new boolean[26];
        visited = new boolean[r][c];
        
        for (int i = 0; i < r; i++) board[i] = sc.next();
        
        alpha_visited[board[0].charAt(0) - 'A'] = true;
        visited[0][0] = true;
        
        dfs(new Pair(0,0,1));
        System.out.println(max_cnt);
    }
}
