/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon4386;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Star{
    double x;
    double y;
    
    public Star(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int[] node = new int[2];
    double distance;

    public Edge(int x, int y, double distance) {
        this.node[0] = x;
        this.node[1] = y;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Edge o){
        return (this.distance < o.distance) ? -1 : 1;
    }
}

public class Main {
    //Create Constellations
    
    /**
     * @param args the command line arguments
     */
    public static double[][] adj;                         //모든 노드에 대해 거리 정보를 저장하는 배열
    public static double getDistance(Star s1, Star s2){   //노드(별) 사이의 거리를 구하는 메소드
        double x_dis = Math.pow((s1.x - s2.x), 2);
        double y_dis = Math.pow((s1.y - s2.y), 2);
        
        return Math.sqrt(x_dis + y_dis);
    }
    
    public static void setDistance(int n, Star[] star){  //adj 배열에 별들의 거리를 저장하는 메소드
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) adj[i][j] = 0;
                else if(adj[i][j] == -1){
                    adj[i][j] = getDistance(star[i], star[j]);
                }
            }
        }
    }
        
    public static ArrayList<Edge> setEdge(int n){       //엣지(간선)을 저장하고 거리순으로 저장하는 메소드
        ArrayList<Edge> e = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++) {               //       1     2     3   
            for (int j = i + 1; j < n; j++) {           //     -------------------    
                if(i == j) continue;                    //  1 |  0   | *1.41 | *3.16 |      i = 0 ~ n까지 반복(세로)
                e.add(new Edge(i, j, adj[i][j]));       //  2 | 1.41 |  0    |   *2  |      j = i + 1 ~ n까지 반복하면 2차원 배열에서 대각원소 기준으로
            }                                           //  3 | 3.16 |  2    |   0  |       위쪽에 있는 원소들만 탐색할 수 있음(양방향 그래프이므로 위쪽만으로 간선을 구성)
        }
        Collections.sort(e);
        return e;
    }
    
    public static int getParent(int[] parent, int x){   //특정 노드가 어떤 그래프에 포함 되어 있는지 알려주는 메소드(부모를 찾아줌)
        //System.out.println("x = " + x + " parent[x] = " + parent[x]);
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    
    public static void unionParent(int x, int y, int[] parent){ //두 노드를 같은 그래프로 합쳐줌(부모를 합침)
        x = getParent(parent, x);
        y = getParent(parent, y);
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static boolean isCycle(int x, int y, int[] parent){ // 두 노드가 싸이클을 구성(같은 그래프에 포함되는지)하는지 판별하는 메소드
        x = getParent(parent, x);
        y = getParent(parent, y);
        return x == y;
    }
    
    public static double getCost(ArrayList<Edge> e, int[] parent){ // Kruskal 알고리즘(노드를 최소 비용으로 연결)
        double sum = 0;
        for (Edge edge : e) {
            if(!isCycle(edge.node[0], edge.node[1], parent)){
                sum += edge.distance;
                unionParent(edge.node[0], edge.node[1], parent);
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parent = new int[n];
        Star[] stars = new Star[n];
        
        adj = new double[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], -1);
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            stars[i] = new Star(sc.nextDouble(), sc.nextDouble());
        }
        
        setDistance(n, stars);
        ArrayList<Edge> e = setEdge(n);

        System.out.printf("%.2f\n", getCost(e, parent));
    }
    
}
