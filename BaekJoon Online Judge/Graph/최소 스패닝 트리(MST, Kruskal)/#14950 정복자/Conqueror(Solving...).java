/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ14950;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
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
    public int compareTo(Edge e){
        return this.cost_ - e.cost_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Integer>[] adj;
    
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
    
    public static int getConquestCosts(int n, int m, int t, Edge[] edge, int[] parent){
        //1번 정점부터 시작해야함
        int cost = -t;
        
        for (Edge e : edge) {
            if(!isSameGraph(e.node_[0], e.node_[1], parent)){
                unionParent(e.node_[0], e.node_[1], parent);
                cost += e.cost_ + t;
                t += t;
                System.out.println(e.node_[0] + " " + e.node_[1] + " 비용 : " + cost);
            }
        }
        
        return cost;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();       //증가하는 비용
        
        int[] parent = new int[n + 1];
        Edge[] edge = new Edge[m];

        for (int i = 1; i < n + 1; i++) parent[i] = i;
        for (int i = 0; i < m; i++){
            edge[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(edge);
        
        System.out.println(getConquestCosts(n,m,t,edge,parent));
    }
    
}
