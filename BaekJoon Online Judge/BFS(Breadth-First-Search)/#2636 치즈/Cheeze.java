/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Gold.BOJ2636;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Cheeze{
    int x_, y_;
    
    public Cheeze(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int col, row;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    public static int[][] map;
    public static Queue<Cheeze> cheezeQ = new LinkedList<>();
    public static Queue<Cheeze> meltQ = new LinkedList<>();
    
    public static boolean isInRange(int x, int y){
        return !(col <= x || x < 0 || row <= y || y < 0);
    }
    
    public static boolean isMelt(Cheeze cur){
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x_ + dx[i];
            int nextY = cur.y_ + dy[i];
            
            if (!isInRange(nextX, nextY)) continue;
            if (map[nextX][nextY] == -1) { // 치즈가 녹는 경우
                meltQ.offer(cur); 
                return true;
            }
        }
        
        return false;
    }
    
    // 녹는 치즈를 먼저 찾아 놓고 녹여야 함
    // 찾으면서 녹이면 그 자리가 0이 되므로 주변 치즈가 계속 녹음
    public static int bfs(int restCheeze){
        // 치즈가 없는 경우 0을 출력
        int size = cheezeQ.size();
        // 녹을 치즈를 찾아서 meltQ에 넣음
        // 녹지 않는 치즈는 다시 cheezeQ에 삽입
        while(size-- != 0){
            Cheeze cur = cheezeQ.poll();
            
            if(!isMelt(cur)) cheezeQ.offer(cur);
        }
        
        // 치즈 녹이기
        while(!meltQ.isEmpty()){
            Cheeze melt = meltQ.poll();
            map[melt.x_][melt.y_] = 0;
            initArea(melt.x_, melt.y_);
            
            restCheeze--; // 남은 치즈 개수 줄여주기
        }
        
        return restCheeze;
    }
    
    public static void initArea(int x, int y){
        if(!isInRange(x, y) || map[x][y] != 0) return;
        map[x][y] = -1;
        
        for (int i = 0; i < 4; i++) initArea(x + dx[i], y + dy[i]);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        col = sc.nextInt();
        row = sc.nextInt();
        map = new int[col][row];
        
        int cheezeCnt = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                map[i][j] = sc.nextInt();
                // 치즈인 경우
                if(map[i][j] == 1) {
                    cheezeCnt++;
                    cheezeQ.offer(new Cheeze(i, j));
                }
            }
        }
        
        initArea(0,0);
        
        // 모든 치즈가 녹을 때까지 반복
        int time = 0;
        int prevCheeze = 0;
        while(!cheezeQ.isEmpty()){
            prevCheeze = cheezeCnt;
            cheezeCnt = bfs(cheezeCnt);
            time++;
        }
        
        System.out.println(time);
        System.out.println(prevCheeze);
    }
    
}
