/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.Baekjoon2887;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Planet{
    int x;
    int y;
    int z;

    public Planet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge>{
    int[] node_ = new int[2];
    int cost_;

    public Edge(int n1, int n2, int cost) {
        this.node_[0] = n1;
        this.node_[1] = n2;
        this.cost_ = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.cost_ - o.cost_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    //행성을 x좌표 기준으로 정렬하고, 그 때 인접한 행성끼리 연결합니다. 
    //y좌표 정렬과 z좌표 정렬도 비슷하게 합니다. 
    //이렇게 했을 때 나오는 간선만 사용해도 최소 비용을 얻을 수 있음을 증명할 수 있습니다.
    
    public static int getParent(int[] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    
    public static void unionParent(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
    
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static boolean isCycle(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        return x == y;
    }
    
    public static int connectCost(Planet p1, Planet p2){
        int x_dis = Math.abs(p1.x - p2.x);
        int y_dis = Math.abs(p1.y - p2.y);
        int z_dis = Math.abs(p1.z - p2.z);
        
        return Math.min(x_dis, Math.min(y_dis, z_dis));
    }
    
    public static ArrayList<Edge> setEdge(ArrayList<Planet> planets){
        int nums_planet = planets.size();
        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < nums_planet - 1; i++) {
            Edge min_edge = null;
            int min_cost = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums_planet; j++) {
                if(i == j) continue;
                //edges.add(new Edge(i, j, connectCost(planets.get(i), planets.get(j))));
                int connect_cost = connectCost(planets.get(i), planets.get(j));
                if(min_cost > connect_cost){
                    min_cost = connect_cost;
                    min_edge = new Edge(i, j, min_cost);
                }
            }
            edges.add(min_edge);
        }
        
        Collections.sort(edges);
        return edges;
    }
        
    public static int compute_min_cost(ArrayList<Edge> edges, int[] parent){
        int cost = 0;
        
        for (Edge edge : edges) {
            if(!isCycle(edge.node_[0], edge.node_[1], parent)){
                cost += edge.cost_;
                unionParent(edge.node_[0], edge.node_[1], parent);
            }
        }
        
        return cost;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //행성의 개수
        int[] parent = new int[n];
        ArrayList<Planet> planets = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            planets.add(new Planet(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            parent[i] = i;
        }
        
        System.out.println(compute_min_cost(setEdge(planets), parent));
    }
    
}
