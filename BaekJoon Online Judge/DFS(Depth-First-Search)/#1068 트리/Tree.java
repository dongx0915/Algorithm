/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ1068;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node{
    int index_;
    int parent_;
    ArrayList<Integer> adj_ = new ArrayList<>();

    public Node(int index) {
        this.index_ = index;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int dfs(Node[] node, int n, int root){
        int reef_node = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<>();
        
        s.push(root);
        visited[root] = true;
        if(node[root].adj_.isEmpty()) return 1;
        
        while(!s.isEmpty()){
            int now = s.pop();
            
            for (Integer child : node[now].adj_) {
                if(!visited[child]){
                    s.push(child);
                    visited[child] = true;
                    if(node[child].adj_.isEmpty()) reef_node++;
                }
            }
        }
        
        return reef_node;
    }
    
    public static void eraseNode(Node[] node, int erase_node, int n){
        Node parent_node = node[node[erase_node].parent_];
        
        int erase_idx = parent_node.adj_.indexOf(erase_node);
        if (erase_idx >= 0) parent_node.adj_.remove(erase_idx);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Node[] node = new Node[n];
        int root_node = 0;
        for (int i = 0; i < n; i++) node[i] = new Node(i);
        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            node[i].parent_ = parent;
            if(parent == -1) root_node = i;
            else if(!node[parent].adj_.contains(i)) node[parent].adj_.add(i);
        }
        
        int erase_node = sc.nextInt();
        
        if(node[erase_node].parent_ == -1) System.out.println("0");
        else{
            eraseNode(node, erase_node, n);
            System.out.println(dfs(node, n, root_node));
        }
    }
}
