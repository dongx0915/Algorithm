/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ21924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
class Edge implements Comparable<Edge>{
    int[] node_ = new int[2];
    int cost_;

    public Edge(int n1, int n2, int cost) {
        this.node_[0] = n1;
        this.node_[1] = n2;
        this.cost_ = cost;
    }
    
    @Override
    public int compareTo(Edge e){
        return (int)(this.cost_ - e.cost_);
    }
}


public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,M;
    
    public static int getParent(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x], parent);
    }
    
    public static void unionParent(int[] node, int[] parent){
        node[0] = getParent(node[0], parent);
        node[1] = getParent(node[1], parent);
        
        if(node[0] < node[1]) parent[node[1]] = node[0];
        else parent[node[0]] = node[1];
    }
    
    public static boolean isCycle(int[] node, int[] parent){
        node[0] = getParent(node[0], parent);
        node[1] = getParent(node[1], parent);
        
        return node[0] == node[1];
    }
    
    public static long getSavingCost(ArrayList<Edge> edges, int[] parent){
         long minCost = 0;
         long total = 0;
         int edgeCnt = 0;
         Collections.sort(edges);
         
         /*
         * 연결 된 엣지 개수를 카운팅
         * 최소 스패닝 트리에서 엣지의 개수는 노드 개수 -1임
         */
         for (Edge edge : edges) {
             total += edge.cost_;
             if(isCycle(edge.node_, parent)) continue;
             
             unionParent(edge.node_, parent);
             minCost += edge.cost_;
             edgeCnt++;
         }

         return (edgeCnt == N-1) ? total - minCost : -1;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());       //건물의 개수
        M = Integer.parseInt(st.nextToken());       //도로의 개수
        
        int[] parent = new int[N+1];
        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < N; i++) parent[i] = i;
        
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        System.out.println(getSavingCost(edges, parent));
    }
    
}
