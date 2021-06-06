/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ18126;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Edge{
    int index_;
    long dis_;

    public Edge(int index_, long dis_) {
        this.index_ = index_;
        this.dis_ = dis_;
    }
    
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<ArrayList<Edge>> rooms;
    public static boolean[] visited;
    public static long max_dis = 0;
    
    public static void dfs(int root, long dis){
        max_dis = Math.max(max_dis, dis);
            
        for (Edge next : rooms.get(root)) {
            if(visited[next.index_]) continue;
            visited[next.index_] = true;
            dfs(next.index_, dis + next.dis_);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        rooms = new ArrayList<>();
        visited = new boolean[n + 1];
        
        for (int i = 0; i < n + 1; i++) rooms.add(new ArrayList<>());
        
        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int dis = sc.nextInt();
            rooms.get(n1).add(new Edge(n2, dis));
            rooms.get(n2).add(new Edge(n1, dis));
        }
        
        visited[1] = true;
        dfs(1, 0);
        
        System.out.println(max_dis);
    }
    
}
