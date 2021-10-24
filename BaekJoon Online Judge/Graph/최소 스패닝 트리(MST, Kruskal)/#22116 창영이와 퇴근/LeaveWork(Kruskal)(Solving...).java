/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kruskcal.BOJ22116;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Edge implements Comparable<Edge>{
    int[] node_ = new int[2];
    int slope_; //경사

    public Edge(int n1, int n2, int slope) {
        node_[0] = n1;
        node_[1] = n2;
        this.slope_ = slope;
    }
    
    @Override
    public int compareTo(Edge e){
        return this.slope_ - e.slope_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[][] map;
    public static PriorityQueue<Edge> edge;
    
    public static void unionParent(int x, int y, int[] parent){
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
    
    public static ArrayList<Edge> setEdge(int N){
        ArrayList<Edge> edge = new ArrayList<>();
        boolean[] visit = new boolean[(N*N) + 1];
        int[] dy = { 0,-1, 0, 1};
        int[] dx = {-1, 0, 1, 0};
        
        //index = (size * i) + j
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int index = (N * i) + j;
                
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    int nextIndex = (N * ny) + nx;
                    
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    if(!visit[index] || !visit[nextIndex]){ //둘 중 하나라도 방문을 안했다면
                        edge.add(new Edge(index, nextIndex, Math.abs(map[i][j] - map[ny][nx])));
                        visit[index] = visit[nextIndex] = true;
                    }
                }
            }
        }
        
        return edge;
    }
    
    public static int getMaxSlope(int N, int[] parent){
        ArrayList<Edge> edge = setEdge(N);
        Collections.sort(edge);
        
        int max = Integer.MIN_VALUE;
        
        for (Edge e : edge) {
            if(isCycle(e.node_[0], e.node_[1], parent)) continue;
            
            
            max = Math.max(max, e.slope_);
            unionParent(e.node_[0], e.node_[1], parent);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        parent = new int[(N*N)+1];
        map = new int[N][N];
        
        for (int i = 1; i < parent.length; i++) parent[i] = i;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(getMaxSlope(N, parent));
    }
}
