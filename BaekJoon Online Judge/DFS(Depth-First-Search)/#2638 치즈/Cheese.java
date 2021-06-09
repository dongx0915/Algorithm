/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ2638;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Pair{
    int x_, y_;

    public Pair(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,M;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    public static int[][] map;
    public static Queue<Pair> cheeseQ = new LinkedList<>();
    public static Queue<Pair> meltedQ = new LinkedList<>();
    
    public static boolean isRange(int x, int y){
        return !(x < 0 || y < 0 || x >= N || y >= M);
    }
    
    public static void areaDfs(int x, int y){
        if(!isRange(x, y) || map[x][y] != 0) return;
        map[x][y] = -1;
        
        areaDfs(x - 1, y);
        areaDfs(x, y - 1);
        areaDfs(x + 1, y);
        areaDfs(x, y + 1);
        
    }
    
    public static void initArea(int x, int y) {              //외부 공간이 영역을 표시하는 메소드
        areaDfs(x,y);
    }
    //치즈에 둘러싸인 영역을 체크하는 방법이 필요함
    
    public static void meltCheese(){                        //녹을 치즈를 표시하고, 치즈를 녹임
        //System.out.println(cheeseQ.size());
        int size = cheeseQ.size();
        
        for (int i = 0; i < size; i++) {                    //이번에 녹는 치즈를 표시
            Pair now = cheeseQ.poll();
            int air_cnt = 1;
            
            for (int j = 0; j < 4; j++) {
                Pair next = new Pair(now.x_ + dx[j], now.y_ + dy[j]);
                if(map[next.x_][next.y_] == -1) air_cnt++;
            }
            
            map[now.x_][now.y_] = air_cnt;
            cheeseQ.add(now);
        }
            
//        printMap();
//        System.out.println("");
        
        for (int i = 0; i < size; i++) {                    //치즈를 녹임
            Pair cheese = cheeseQ.poll();
            
            if(map[cheese.x_][cheese.y_] >= 3){
                map[cheese.x_][cheese.y_] = 0;              //녹은 치즈를 Queue에 저장
                meltedQ.add(cheese);
                continue;
            }
            cheeseQ.add(cheese);
        }
        
    }
    
    public static void printMap(){
        for (int[] is : map) {
            for (int i : is) {
                if(i == -1) System.out.print(" #");
                else System.out.printf("%2d", i);
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       // 세로
        M = sc.nextInt();       // 가로
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] >= 1) cheeseQ.offer(new Pair(i,j));
            }
                
        
        //initArea(0,0); //처음 외부 공간 영역을 -1로 셋팅함
        int time = 0;
        initArea(0, 0);
        //printMap();
        
        while(!cheeseQ.isEmpty()){
            meltCheese();
            //printMap();
            while(!meltedQ.isEmpty()){
                Pair cheese = meltedQ.poll();
                initArea(cheese.x_, cheese.y_);
            }
            time++;
        }

        System.out.println(time);
    }
    
}
