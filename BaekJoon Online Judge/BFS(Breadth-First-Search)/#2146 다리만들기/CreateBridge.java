/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon.CreateBridge;

import java.util.Arrays;
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

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CreateBridge {
    public static int N;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[][] visited;
    
    public static void printMap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
        
    public static void init_visited(){              //매 경우 바다에 대한 visited를 초기화 해주어야함
        for (boolean[] bs : visited) {              
            Arrays.fill(bs, false);                 
        }
    }
    
    public static boolean isEdge(Point next){       // 4 방향 모두 0이 아니면 가장자리가 아님(0이 하나라도 있으면 가장자리)
        for (int i = 0; i < 4; i++) {
            Point nxt = new Point(next.x + dx[i], next.y + dy[i]);
            if(nxt.x < 0 || nxt.x >= N || nxt.y < 0 || nxt.y >= N) continue;
            if(map[nxt.x][nxt.y] != 0) continue;
            return true;
        }
        
        return false;
    }
    public static int findBridge_bfs(Point root){
        init_visited();                             //visited 초기화
        int root_idx = map[root.x][root.y];
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> dis_q = new LinkedList<>();
        
        q.add(root);
        visited[root.x][root.y] = true;
        dis_q.add(0);
        
        while(!q.isEmpty()){
            Point now = q.poll();
            int dis = dis_q.poll();

            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) continue;
                if(map[next.x][next.y] != 0 && map[next.x][next.y] != root_idx) return dis;     //0이 아니고 root_idx(현재 섬의 번호)랑 다르면 다른 섬에 도착한 것
                if(map[next.x][next.y] != 0) continue;                      // 틀린이유 : 여기서 isEdge를 체크했음
                if(!visited[next.x][next.y]){
                    q.add(next);
                    dis_q.add(dis + 1);
                    visited[next.x][next.y] = true;
                }
            }
        }
        
        return 9999;                    //9999대신 다른 
    }
    
    public static int getShortestBridge(){
        int min = 9999;
        init_visited();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && isEdge(new Point(i,j))) { //0이 아니고 엣지이면
                    int dis = findBridge_bfs(new Point(i,j));
                    if (dis >= 0) if (min > dis) min = dis;
                }
            }
        }
        
        return min;
    }
    
    public static void setAreaBfs(Point root, int index, boolean[][] visited){
        Queue<Point> q = new LinkedList<>();
        
        q.add(root);
        visited[root.x][root.y] = true;
        map[root.x][root.y] = index;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) continue;
                if(!visited[next.x][next.y] && map[next.x][next.y] != 0){
                    q.add(next);
                    visited[next.x][next.y] = true;
                    map[next.x][next.y] = index;
                }
            }
        }
    }
    
    public static void setArea(){
        int index = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) setAreaBfs(new Point(i,j), index++, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        setArea();
        System.out.println(getShortestBridge());
    }
    
}
