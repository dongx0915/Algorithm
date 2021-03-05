package BFS.Baekjoon2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point{
    int x;
    int y;
    boolean broken = false;
   
    public Point(int x, int y, boolean broken){
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}

public class Main {
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static void printStatus(StringBuilder[] map){
        for (StringBuilder stringBuilder : map) {
            System.out.println(stringBuilder);
        }
        System.out.println("");
        System.out.println("");
    }
    
    public static int bfs(StringBuilder[] map){
        int n = map.length;
        int m = map[0].length();
        int[][] visited = new int[n][m]; // 1 : 벽을 부수고 방문, 0 : 방문 x, -1 : 벽 안 부수고 방문
        
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> dis_q = new LinkedList<>();

        q.add(new Point(0,0, false));
        dis_q.add(1);
        visited[0][0] = -1;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            int dis = dis_q.poll();
            
            if(now.x == n - 1 && now.y == m - 1) return dis;
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i], now.broken);
                if(next.x < 0 || next.x >= n || next.y < 0 || next.y >= m) continue;
                if(next.broken){
                    if(map[next.x].charAt(next.y) == '0' && visited[next.x][next.y] == 0){
                        q.add(next);
                        dis_q.add(dis + 1);
                        visited[next.x][next.y] = 1;
                    }
                }
                else{
                    if(map[next.x].charAt(next.y) == '1'){
                        if(visited[next.x][next.y] == 0){       // 벽 부수고 방문(1)은 현재 위치에서 벽을 부수고 그 자리로 가면 결국 똑같은 경우이므로 안가도됨
                            next.broken = true;
                            q.add(next);                        // 벽 안부수고 방문(-1)은 이미 최선의 경우이므로 안가도됨
                            dis_q.add(dis + 1);
                            visited[next.x][next.y] = 1;
                        }
                    }
                    else{
                        if(visited[next.x][next.y] != -1){
                            q.add(next);
                            dis_q.add(dis + 1);
                            visited[next.x][next.y] = -1;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //세로(y)
        int m = sc.nextInt();   //가로(x)
        StringBuilder[] map = new StringBuilder[n];
        
        for (int i = 0; i < n; i++) {
            map[i] = new StringBuilder(sc.next());
        }
        
        System.out.println(bfs(map));
    }
}
