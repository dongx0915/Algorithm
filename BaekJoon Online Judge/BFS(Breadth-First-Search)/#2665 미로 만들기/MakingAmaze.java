/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gold.BOJ2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point{
    int x_;
    int y_;

    public Point(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    public static int[][] dis;
    public static StringBuilder[] map;
    
    /*
    * dis : 현재 위치까지 부순 벽의 개수
    * bfs로 탐색
    * 이동 가능한 칸인 경우 부순 벽의 개수를 체크한다. 현재 칸이 다음 칸보다 적은 벽을 부수고 왔으면 갱신한다.
    * 벽을 만난 경우 현재 부순 벽의 개수 + 1을 하고 queue에 추가한다.
    */
    
    public static int bfs(){
        Queue<Point> q = new LinkedList<>();
        
        q.offer(new Point(0,0));
        dis[0][0] = 0;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(cur.x_ + dx[i], cur.y_ + dy[i]);
                
                if(next.x_ < 0 || next.y_ < 0 || next.x_ >= N || next.y_ >= N) continue;
                char nextCh = map[next.x_].charAt(next.y_);
                
                // 현재 칸이 다음 칸보다 적게 부수고 온 경우(갱신 필요)
                if(dis[next.x_][next.y_] > dis[cur.x_][cur.y_]){
                   
                   // 이동 가능한 칸이면 현재 부순 벽의 개수를 다음 칸에 대입
                   if(nextCh == '1') dis[next.x_][next.y_] = dis[cur.x_][cur.y_];
                   // 벽을 만나면 현재 칸의 부순 벽의 개수 + 1
                   else dis[next.x_][next.y_] = dis[cur.x_][cur.y_] + 1;
                   
                   q.offer(next);
                }
            }
        }
        
        return dis[N-1][N-1];
    }
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new StringBuilder[N];
        dis = new int[N][N];
        // 다음 칸보다 현재 칸이 작을 경우 이동하므로 최댓값으로 설정해줘야함
        for (int i = 0; i < N; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) map[i] = new StringBuilder(br.readLine());
        
        System.out.println(bfs());
    }
    
}
