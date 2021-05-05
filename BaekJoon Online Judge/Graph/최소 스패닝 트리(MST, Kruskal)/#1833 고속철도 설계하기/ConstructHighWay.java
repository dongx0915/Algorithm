/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ1833;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;

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
    public int compareTo(Edge e){
        return this.cost_ - e.cost_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    //출력
    //총 비용    |    새로 설치한 고속철도 개수
    //새로 설치된 두 도시 번호
    
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
    
    public static boolean isSameGraph(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        return x == y;
    }
    
    public static void constructHighWay(ArrayList<Edge> edges, int[] parent, int built_way_cost){
        StringJoiner connected_city = new StringJoiner("\n");
        int cost = 0;
        int connect = 0;
        
        for (Edge edge : edges) {
            if(!isSameGraph(edge.node_[0], edge.node_[1], parent)){
                cost += edge.cost_;
                unionParent(edge.node_[0], edge.node_[1], parent);
                connected_city.add((edge.node_[0] + 1) + " " + (edge.node_[1] + 1));
                connect++;
            }
        }
        
        System.out.println((built_way_cost + cost) + " " + connect);
        if(connect != 0) System.out.println(connected_city);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] adj = new int[n][n];
        int[] parent = new int[n];
        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) adj[i][j] = sc.nextInt();
        
        int built_way_cost = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(adj[i][j] < 0){
                    built_way_cost += adj[i][j] * -1;
                    unionParent(i,j,parent);
                }
                else edges.add(new Edge(i,j, adj[i][j]));
            }
        }
        
        Collections.sort(edges);
        constructHighWay(edges, parent, built_way_cost);
    }
    
}
