/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kruskal.BOJ22116;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Edge{
    int[] node_;
    int slope_; //경사

    public Edge(int n1, int n2, int slope) {
        node_[0] = n1;
        node_[1] = n2;
        this.slope_ = slope;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[][] map;
    public static PriorityQueue<Edge> edge;
    
    public static void unionFind(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static int getParent(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x], parent);
    }
    
    public static boolean isCycle(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        
        return x == y;
    }
    
    public static PriorityQueue<Edge> setEdge(int N){
        PriorityQueue<Edge> edge = new PriorityQueue<>();
        int[] dy = { 0,-1, 0, 1};
        int[] dx = {-1, 0, 1, 0};
        
        //index = (size * i) + j
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int index = (N * i) + j;
                
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    edge.add(new Edge(index, (N * ny) + nx, Math.abs(map[i][j] - map[ny][nx])));
                }
            }
        }
        
        return edge;
    }
    
    public static void setMst(int N){
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        parent = new int[N + 1];
        map = new int[N][N];
        
        for (int i = 1; i < N+1; i++) parent[i] = i;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }
}
