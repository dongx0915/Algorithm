/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ14267;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node{
    int index_;
    int parent_;
    int praise_ = 0;
    boolean visited_ = false;
    ArrayList<Integer> adj = new ArrayList<>();

    public Node(int index_) {
        this.index_ = index_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static Node[] node;
    
    public static void dfs(Node root){
        root.visited_ = true;
        
        for (Integer next : root.adj){
            node[next].praise_ += root.praise_;
            dfs(node[next]);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        node = new Node[n + 1];
        
        //한 직원이 다른 칭찬 정도로 여러번 칭찬을 받는다면 칭찬 정도는 어느 값으로 ?
        for (int i = 0; i < n + 1; i++) node[i] = new Node(i);
        for (int i = 0; i < n; i++){ 
            int parent = sc.nextInt();
            node[i + 1].parent_ = parent;
            if(parent != -1) node[parent].adj.add(i + 1);
        }
        for (int i = 0; i < m; i++){
            node[sc.nextInt()].praise_ += sc.nextInt();
        }
        dfs(node[1]);
        
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 1; i < n + 1; i++) sj.add(node[i].praise_ + "");
            
        System.out.println(sj);
    }
    
}
