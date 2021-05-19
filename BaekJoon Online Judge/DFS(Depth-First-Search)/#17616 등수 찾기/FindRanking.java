/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ17616;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node{
    int index_;
    boolean visited_ = false;
    Set<Integer> parent_ = new HashSet<>();
    Set<Integer> child_ = new HashSet<>();

    public Node(int index_) {
        this.index_ = index_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int u, v;
    public static Node[] node;
    public static boolean[] visited;
    
    public static void dfs_child(int start){
        if(node[start].child_.isEmpty()) return;
        
        Iterator<Integer> child = node[start].child_.iterator();
        
        while(child.hasNext()){
            int next = child.next();
            
            if(!visited[next]){
                visited[next] = true;
                v--;
                dfs_child(next);
            }
        }
    }
    
    public static void dfs_parent(int start){
        if(node[start].parent_.isEmpty()) return;
        
        Iterator<Integer> parent = node[start].parent_.iterator();
        
        while(parent.hasNext()){
            int next = parent.next();
            
            if(!visited[next]){
                visited[next] = true;
                u++;
                dfs_parent(next);
            }
        }
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //학생(노드) 수
        int m = sc.nextInt();       //질문(간선) 수
        int x = sc.nextInt();       //타겟 학생
        
        node = new Node[n + 1];
        u = 1;
        v = n;
        
        for (int i = 0; i < n + 1; i++) node[i] = new Node(i);
        for (int i = 0; i < m; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            node[n1].child_.add(n2);
            node[n2].parent_.add(n1);
        }
        
        visited = new boolean[n + 1];
        dfs_parent(x);
        
        visited = new boolean[n + 1];
        dfs_child(x);
            
        System.out.println(u + " " + v);
    }
    
}
