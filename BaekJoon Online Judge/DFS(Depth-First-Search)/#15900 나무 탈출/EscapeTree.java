/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ15900;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node{
    int index_;
    boolean visited_ = false;
    ArrayList<Integer> childs = new ArrayList<>();

    public Node(int index_) {
        this.index_ = index_;
    }
}

public class Main {
    public static Node[] node;
    public static int node_cnt = 0;
    
    public static boolean isReefNode(Node target){
        for (Integer child : target.childs) if(!node[child].visited_) return false;
        return true;
    }
    
    public static void dfs(Node root, int cnt){
        //System.out.println(root.index_ + " 방문");
        
        if(isReefNode(root)) node_cnt += cnt;
        root.visited_ = true;
        
        for (Integer child : root.childs) {
            if(!node[child].visited_) dfs(node[child], cnt + 1);
        }
    }
    
    public static void addGraph(Node n1, Node n2){
        if(!n1.childs.contains(n2.index_)) n1.childs.add(n2.index_);
        if(!n2.childs.contains(n1.index_)) n2.childs.add(n1.index_);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //정점의 개수
        node = new Node[n + 1];
        
        for (int i = 0; i < n + 1; i++) node[i] = new Node(i);
        for (int i = 0; i < n - 1; i++) addGraph(node[sc.nextInt()], node[sc.nextInt()]);
        
        dfs(node[1], 0);
        
        //System.out.println(node_cnt);
        if(node_cnt % 2 != 0) System.out.println("YES");
        else System.out.println("NO");
    }
    
}
