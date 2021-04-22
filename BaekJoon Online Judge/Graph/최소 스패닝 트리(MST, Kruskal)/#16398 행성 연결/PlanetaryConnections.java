/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.Baekjoon16398;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Edge implements Comparable<Edge>{
    int[] node_ = new int[2];
    int cost_;

    public Edge(int n1, int n2, int cost_) {
        this.node_[0] = n1;
        this.node_[1] = n2;
        this.cost_ = cost_;
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
    //관리 비용은 long으로 선언
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
    
    public static ArrayList<Edge> setEdge(int[][] planets_costs){
        int n = planets_costs.length;
        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, Math.min(planets_costs[i][j], planets_costs[j][i])));
            }
        }
        Collections.sort(edges);
        return edges;
    }
    
    public static long computeCost(ArrayList<Edge> edges, int[] parent){
        long cost = 0;
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
        int n = sc.nextInt();       //행성의 수
        int[] parent = new int[n];
        int[][] planets_costs = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            for (int j = 0; j < n; j++) {
                planets_costs[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(computeCost(setEdge(planets_costs), parent));
    }
    
}
