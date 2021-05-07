/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.BOJ2573;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Pair{
    int x_;
    int y_;

    public Pair(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

class Ice{
    int x_;
    int y_;
    int melt_;

    public Ice(int x_, int y_, int melt_) {
        this.x_ = x_;
        this.y_ = y_;
        this.melt_ = melt_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int N, M;
    
    public static int sectionBfs(int[][] ocean, int x, int y){
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(x,y));
        ocean[x][y] = -1;
        
        while(!q.isEmpty()){
            Pair now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(now.x_ + dx[i], now.y_ + dy[i]);
                if(next.x_ < 0 || next.x_ >= N || next.y_ < 0 || next.y_ >= M) continue;
                if(ocean[next.x_][next.y_] > 0){
                    q.add(next);
                    ocean[next.x_][next.y_] = -1;
                }
            }
        }
        
        return 1;
    }
    
    public static int getSection(int[][] ocean){
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) copy[i] = ocean[i].clone();
        
        int section = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] > 0) section += sectionBfs(copy, i,j);
            }
        }
        
        return section;
    }
    
    public static int meltIce(int[][] ocean, ArrayList<Ice> ice_list){
        int time = 0;
        
        while(true){
            int section = getSection(ocean);
            //System.out.println("Sec : " + section);
            if(section >= 2) break;
            if(section == 0) return 0;
 
            for (Ice ice : ice_list) {
                int melt_cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int next_x = ice.x_ + dx[i];
                    int next_y = ice.y_ + dy[i];
                    if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M) continue;
                    if (ocean[next_x][next_y] == 0) melt_cnt++;
                }
                ice.melt_ = melt_cnt;
            }

            for (Ice ice : ice_list) {
                ocean[ice.x_][ice.y_] -= ice.melt_;
                if(ocean[ice.x_][ice.y_] < 0) ocean[ice.x_][ice.y_] = 0;
            }
            
            time++;
        }
        
        return time;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       //세로
        M = sc.nextInt();       //가로
        int[][] ocean = new int[N][M];
        ArrayList<Ice> ice_list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ocean[i][j] = sc.nextInt();
                if(ocean[i][j] > 0) ice_list.add(new Ice(i,j, 0));
                //입력받으면서 빙산의 좌표를 저장
                //빙산의 좌표만 반복
            }
        }
        
        //System.out.println(getSection(ocean));
        System.out.println(meltIce(ocean, ice_list));
        
    }
    
}
