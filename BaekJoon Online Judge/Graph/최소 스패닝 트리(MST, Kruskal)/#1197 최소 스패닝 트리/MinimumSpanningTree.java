/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph.Baekjoon1197;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Edge implements Comparable<Edge>{
    int[] node = new int[2];
    int weight;

    public Edge(int x, int y, int weight) {
        this.node[0] = x;
        this.node[1] = y;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.weight - o.weight;
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
    
    public static int getWeight(Edge[] edges, int[] parent){
        int weight = 0;
        
        for (Edge edge : edges) {
            if(!checkCycle(edge.node[0] - 1, edge.node[1] - 1, parent)){
                weight += edge.weight;
                unionParent(edge.node[0] - 1, edge.node[1] - 1, parent);
            }
        }
        
        return weight;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();       //정점의 개수
        int e = sc.nextInt();       //간선의 개수
        int[] parent = new int[v];
        Edge[] edges = new Edge[e];
        
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        
        Arrays.sort(edges);
        System.out.println(getWeight(edges, parent));
    }
    
}
