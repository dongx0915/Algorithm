import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

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
    public static int n,m;
    public static int[] dy = { 0,-1, 0, 1};  
    public static int[] dx = {-1, 0, 1, 0};  
    public static ArrayList<Integer> shape_size = new ArrayList<>();
    public static boolean[][] visited;
    
    public static void dfs(Pair root, int[][] map, int shape_cnt){
        int size = 1;
        Stack<Pair> s = new Stack<>();
        
        s.push(root);
        visited[root.x_][root.y_] = true;
        map[root.x_][root.y_] = shape_cnt;
        
        while(!s.isEmpty()){
            Pair cur = s.pop();
            
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x_ + dx[i], cur.y_ + dy[i]);
                if(next.x_ < 0 || next.y_ < 0 || next.x_ >= n || next.y_ >= m) continue;
                if(!visited[next.x_][next.y_] && map[next.x_][next.y_] == 1){
                    s.push(next);
                    visited[next.x_][next.y_] = true;
                    map[next.x_][next.y_] = shape_cnt;
                    size++;
                }
            }
        }
        
        shape_size.add(size);
    }
    
    public static int getMaxShapeSize(int[][] map){
        int max_size = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    HashSet<Integer> visit = new HashSet<>();  //방문한 그룹의 번호를 저장
                    
                    int temp_size = 0;
                    int overlap = 0;
                    for (int k = 0; k < 4; k++) {
                        Pair next = new Pair(i + dx[k], j + dy[k]);
                        if(next.x_ < 0 || next.y_ < 0 || next.x_ >= n || next.y_ >= m) continue;
                        int next_map = map[next.x_][next.y_];
                        
                        if(!visit.contains(next_map) && next_map != 0){
                            visit.add(next_map);
                            temp_size += shape_size.get(next_map - 1) + 1;
                            overlap++;
                        }
                    }
                    max_size = Math.max(temp_size - (overlap - 1), max_size);
                }
            }
        }
        
        return max_size;
    }
    
    public static void setShapeNum(int[][] map){
        int shape_cnt = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    dfs(new Pair(i, j), map, shape_cnt++);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][m];
        visited  = new boolean[n][m];
        
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++)map[i][j] = sc.nextInt();

        setShapeNum(map);
        System.out.println(getMaxShapeSize(map));
    }
}
