/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ14950;

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

class Node{
    int index_;
    ArrayList<Edge> edge_ = new ArrayList<>();

    public Node(int index_) {
        this.index_ = index_;
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
    
    public static void printParent(int[] parent){
        System.out.print("parent : ");
        for (int i : parent) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static int getConquestCosts(Node[] node, int[] parent, int n, int t){
        //1번 정점부터 시작해야함
        int cost = 0;
        int connect_cnt = 1;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(node[1].edge_);
        
        while(!pq.isEmpty()){
            Edge next = pq.poll();
            if(isSameGraph(next.node_[0], next.node_[1], parent)) continue;
            int n1 = getParent(parent, next.node_[0]);
            int n2 = getParent(parent, next.node_[1]);
            int next_node = parent[n1] == 1 ? n2 : n1;
            
            //System.out.println("다음 노드 : " + next_node);
            unionParent(next.node_[0], next.node_[1], parent);
            cost += next.cost_ + (t * (connect_cnt - 1));
            connect_cnt++;
            
            pq.addAll(node[next_node].edge_);
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
        Node[] node = new Node[n + 1];
        
        for (int i = 1; i < n + 1; i++){
            parent[i] = i;
            node[i] = new Node(i);
        }
        
        for (int i = 0; i < m; i++){
            Edge input = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
            node[input.node_[0]].edge_.add(input);
            node[input.node_[1]].edge_.add(input);
        }
        
        System.out.println(getConquestCosts(node, parent, n, t));
    }
}
