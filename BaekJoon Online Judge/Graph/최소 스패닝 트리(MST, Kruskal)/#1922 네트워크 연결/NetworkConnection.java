/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph.Baekjoon1922;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Edge implements Comparable<Edge>{
    int[] node = new int[2];
    int cost;

    public Edge(int x, int y, int cost) {
        this.node[0] = x;
        this.node[1] = y;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
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
    
    public static boolean checkCycle(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        return x == y;
    }
    
    public static int getCost(ArrayList<Edge> e, int[] parent){
        int cost = 0;
        for (Edge edge : e) {
            if(!checkCycle(edge.node[0] - 1, edge.node[1] - 1, parent)){
                cost += edge.cost;
                unionParent(edge.node[0] - 1, edge.node[1] - 1, parent);
            }
        }
        
        return cost;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();       //컴퓨터 수
        int m = sc.nextInt();       //간선 수
        int[] parent = new int[n];
        ArrayList<Edge> e = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            e.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        
        Collections.sort(e);
        
        System.out.println(getCost(e, parent));
    }
    
}
