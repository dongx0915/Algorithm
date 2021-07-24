/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ16958;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class City{
    int x_;
    int y_;
    boolean isSpecial_;

    public City(int isSpecial_, int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
        this.isSpecial_ = (isSpecial_ == 1);
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N, T;
    public static final int INF = 10000;
    
    public static int getDistance(City c1, City c2){
        int distance = Math.abs(c1.x_ - c2.x_) + Math.abs(c1.y_ - c2.y_);
        if(c1.isSpecial_ && c2.isSpecial_) return Math.min(distance, T);
        return distance;
    }
    
    public static void setDistance(ArrayList<City> cities, int[][] dis){
        for (int[] di : dis) Arrays.fill(di, INF);
        for (int i = 0; i < N; i++) {
            City c1 = cities.get(i);
            for (int j = 0; j < N; j++) {
                City c2 = cities.get(j);
                if(i == j) dis[i][j] = dis[j][i] = 0;
                else dis[i][j] = dis[j][i] = getDistance(c1, c2);
            }
        }
    }
    
    public static void floyd(int[][] dis){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == i || k == i || j == k) continue;
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       //도시 수   
        T = sc.nextInt();       //텔레포트에 걸리는 시간
        
        ArrayList<City> cities = new ArrayList<>();
        int[][] dis = new int[N][N];
        
        /**
         * 각 도시의 위치가 좌표로 입력되기 때문에 
         * 도시의 좌표를 다 입력받고 각 도시끼리의 거리를 저장해줘야함
         */
        
        //new City(int isSpecial_, int x_, int y_)
        for (int i = 0; i < N; i++) 
            cities.add(new City(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        
        setDistance(cities, dis);
        floyd(dis);
        
        int M = sc.nextInt();
        
        for (int i = 0; i < M; i++) System.out.println(dis[sc.nextInt() - 1][sc.nextInt() - 1]);
    }
    
}
