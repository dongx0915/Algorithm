/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ13905;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
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

class Edge{
    int index_;
    int weight_;

    public Edge(int index_, int weight_) {
        this.index_ = index_;
        this.weight_ = weight_;
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
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> limitQ = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        
        q.add(s);
        limitQ.add(Integer.MAX_VALUE);
        visited[s] = true;
        
        //최소 스패닝 트리(MST)에서는 사이클이 존재하지 않으므로
        //특정 노드(S) 특정 노드(H)까지 경로는 단 하나만 존재함
        
        while(!q.isEmpty()){
            int cur = q.poll();
            int limit = limitQ.poll();
            if(cur == h) return limit;
            
            for (Edge next : graph[cur]) {
                if(visited[next.index_]) continue; //이미 방문헀으면 continue
                if(limit >= next.weight_){
                    q.add(next.index_);
                    limitQ.add(next.weight_);
                    visited[next.index_] = true;
                }
            }
        }
        
        return -1;
    }
    
    public static int takeablePepero(ArrayList<Bridge> bridge, int[] parent, int s, int h){
        for (Bridge b : bridge) {
            if(isInGroup(b.home_[0], b.home_[1], parent)) continue;
            
            //System.out.printf("[%d %d] 연결 w = %d\n", b.home_[0], b.home_[1], b.weight_);
            unionParent(b.home_[0], b.home_[1], parent);
            setEdge(b);
        }
        
        return getPeperoCnt(s, h);
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
