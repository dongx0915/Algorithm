/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ2668;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node{
    int index_;
    int child_ = -1;
    boolean goChild_ = false;
    
    public Node(int index_) {
        this.index_ = index_;
    }
    
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static Node[] nodes;
    //first가 첫 노드
    
    public static void dfs(int first, int node, ArrayList<Integer> result){
        if((first == node) && nodes[first].goChild_ && nodes[node].goChild_){
            result.add(node);
            return;
        }
        
        if(!nodes[node].goChild_){
            nodes[node].goChild_ = true;
            dfs(first, nodes[node].child_, result);
            nodes[node].goChild_ = false;
        }
    }
    
    public static void getSequence(int n){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) dfs(i, i, result);
        
        Collections.sort(result);
        System.out.println(result.size());
        
        for (Integer integer : result) System.out.println(integer);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        nodes = new Node[n + 1];
        
        for (int i = 1; i < n + 1; i++) nodes[i] = new Node(i);
        for (int i = 1; i < n + 1; i++) nodes[i].child_ = sc.nextInt();
        
        getSequence(n);
    }
    
}
