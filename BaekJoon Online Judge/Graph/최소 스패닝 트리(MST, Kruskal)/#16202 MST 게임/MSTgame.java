/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ16202;

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
    int weight_;

    public Edge(int n1, int n2, int weight_) {
        this.node_[0] = n1;
        this.node_[1] = n2;
        this.weight_ = weight_;
    }
    
    @Override
    public int compareTo(Edge e){
        return this.weight_ - e.weight_;
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
    
    public static boolean isCycle(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        return x == y;
    }
    
    public static boolean isMst(int[] parent){
        int n = parent.length;
        for (int i = 1; i < n - 1; i++) if(parent[i] != parent[i + 1]) return false;
        
        return true;
    }
    
    public static int getMstScore(ArrayList<Edge> edges, int[] parent){
        //간선의 개수가 n - 1보다 작을 땐 MST를 구성할 수 없음
        int edge_cnt = edges.size();
        if(edge_cnt < parent.length - 2) return 0;
        
        int score = 0;
        Edge min_edge = edges.get(0);
        int min_index = 0;
        int connect_cnt = 0;

        for (int i = 0; i < edge_cnt; i++) {
            Edge nowE = edges.get(i);
            if(!isCycle(nowE.node_[0], nowE.node_[1], parent)){
                unionParent(nowE.node_[0], nowE.node_[1], parent);
                score += nowE.weight_;
                connect_cnt++;

              if(min_edge.weight_ > nowE.weight_){
                    min_edge = nowE;
                    min_index = i;
                }
            }
        }

        edges.remove(min_index);
        return (connect_cnt == parent.length - 2) ? score : 0;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //정점 개수
        int m = sc.nextInt();       //간선 개수
        int turn = sc.nextInt();    //턴의 수
        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), i + 1));
        }
        
        Collections.sort(edges);
        
        StringJoiner sj = new StringJoiner(" ");
        int[] parent = new int[n + 1];
        boolean canMst = true;
        
        for (int i = 0; i < turn; i++) {
            if(canMst){
                for (int j = 0; j < n + 1; j++) parent[j] = j;
                int score = getMstScore(edges, parent);
                
                if(score == 0) canMst = false;
                sj.add(score + "");
            }
            else sj.add("0");
        }
        
        System.out.println(sj);
    }
}
