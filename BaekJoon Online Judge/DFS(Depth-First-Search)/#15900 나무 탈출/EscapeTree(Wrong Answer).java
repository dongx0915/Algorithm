  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node implements Comparable<Node>{
    int index_;
    boolean visited_ = false;
    HashSet<Integer> childs = new HashSet<>();

    public Node(int index_) {
        this.index_ = index_;
    }
    
    @Override
    public int compareTo(Node n){
        return this.index_ - n.index_;
    }
}

public class Main {
    public static Node[] node;
    public static int node_cnt = 0;
    
    public static void dfs(Node root, int cnt){
        boolean flag = false;
        root.visited_ = true;
        
        for (Integer child : root.childs) {
            if(!node[child].visited_){
                flag = true;
                dfs(node[child], cnt + 1);
            }
        }
        if(!flag) node_cnt += cnt;
    }
    
    public static void addGraph(Node n1, Node n2){
//        if(!n1.childs.contains(n2.index_)) n1.childs.offer(n2.index_);
//        if(!n2.childs.contains(n1.index_)) n2.childs.offer(n1.index_);
        n1.childs.add(n2.index_);
        n2.childs.add(n1.index_);
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());       //정점의 개수
        node = new Node[n + 1];
        
        for (int i = 0; i < n + 1; i++) node[i] = new Node(i);
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            addGraph(node[Integer.parseInt(input[0])], node[Integer.parseInt(input[1])]);
        }
        
        dfs(node[1], 0);
        
        //System.out.println(node_cnt);
        if(node_cnt % 2 != 0) System.out.println("YES");
        else System.out.println("NO");
    }
    
}
