/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ13905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Bridge implements Comparable<Bridge>{
    int[] home_ = new int[2];
    int weight_;

    public Bridge(int h1, int h2, int w) {
        this.home_[0] = h1;
        this.home_[1] = h2;
        this.weight_ = w;
    }
    
    @Override
    public int compareTo(Bridge b){
        return b.weight_ - this.weight_;
    }
}

class Edge implements Comparable<Edge>{
    int index_;
    int w_;

    public Edge(int index_, int weight_) {
        this.index_ = index_;
        this.w_ = weight_;
    }
    
    @Override
    public int compareTo(Edge e){
        return e.w_ - this.w_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int n;       //집의 수       - vortex
    public static int m;       //다리의 수     - edge
    public static int s;       //숭이의 위치   - start
    public static int h;       //혜빈이의 위치 - end
    public static ArrayList<Edge>[] graph;
    public static final int INF = 1000001;
    
    public static int getParent(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x], parent);
    }
    
    public static void unionParent(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static boolean isInGroup(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        
        return x == y;
    }
    
    public static void setEdge(Bridge b){
        graph[b.home_[0]].add(new Edge(b.home_[1], b.weight_));
        graph[b.home_[1]].add(new Edge(b.home_[0], b.weight_));
    }
    
    public static int getPeperoCnt(int s, int h){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int n = graph.length;
        int[] w = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(w, INF);
        
        w[s] = INF;
        visited[s] = true;
        pq.offer(new Edge(s, w[s]));
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            //if(w[cur.index_] != INF) continue; //이미 갱신이 된 경우
            
            for (Edge next : graph[cur.index_]) {
                if(visited[next.index_]) continue;
                //무게 제한이 작은 쪽의 값을 넣어줌
                if(next.w_ >= w[cur.index_]) w[next.index_] = w[cur.index_];
                else w[next.index_] = next.w_;
                
                visited[next.index_] = true;
                pq.offer(new Edge(next.index_, w[next.index_]));
                
            }
        }
        
        return w[h] == INF ? 0 : w[h];
    }
           
    public static int takeablePepero(ArrayList<Bridge> bridge, int[] parent, int s, int h){
        for (Bridge b : bridge) {
            if(isInGroup(b.home_[0], b.home_[1], parent)) continue;
            
            unionParent(b.home_[0], b.home_[1], parent);
            setEdge(b);
        }
        
        return getPeperoCnt(s,h);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        h = sc.nextInt();
        //시작지점과 도착지점을 고려해야함
        
        int[] parent = new int[n + 1];
        ArrayList<Bridge> bridge = new ArrayList<>();
        graph = new ArrayList[n + 1];
        
        
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) bridge.add(new Bridge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        
        Collections.sort(bridge);
        System.out.println(takeablePepero(bridge, parent, s, h));
    }
}
