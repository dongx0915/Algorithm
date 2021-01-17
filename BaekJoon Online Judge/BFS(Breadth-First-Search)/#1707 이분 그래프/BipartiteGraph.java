/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon.BipartiteGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node{
    int vortex;
    int color = -1;
    ArrayList<Integer> adjcent;

    public Node(int vortex) {
        this.vortex = vortex;
        this.adjcent = new ArrayList<>();
    }

    public void setColor(int color) {
        this.color = color;
    }
}

public class BipartiteGraph {
    public static int test;
    public static int vortex;
    public static int edge;
    public static Node[] node;
    public static boolean[] visited;
    public static void addEdge(int n1, int n2){
        if(!node[n1].adjcent.contains(n2)) node[n1].adjcent.add(n2);
    }
    
    public static boolean bfs(Node root){

        //System.out.println("node[" + root.vortex + "] 호출됨");
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        visited[root.vortex] = true;
        if(root.color == -1) root.setColor(0);
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for (Integer next : now.adjcent) {
                if(node[next].color == now.color) return false;
                
                if(!visited[node[next].vortex]){
                    if(node[next].color == -1) node[next].setColor(now.color == 0 ? 1 : 0);
                    q.add(node[next]);
                    visited[node[next].vortex] = true;
                }
            }
        }
        return true;
    }
    public static String isBipartiteGraph(){
        for (int i = 1; i < vortex + 1; i++) {
            if(!visited[i]) if(!bfs(node[i])) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        test = sc.nextInt();
        
        while(test-- != 0){
            vortex = sc.nextInt();
            edge = sc.nextInt();
            node = new Node[vortex + 1];
            visited = new boolean[vortex + 1];
            for (int i = 0; i < vortex + 1; i++) {
                node[i] = new Node(i);
            }
            
            for (int i = 0; i < edge; i++) {
                addEdge(sc.nextInt(), sc.nextInt());
            }
            
            System.out.println(isBipartiteGraph());
        }
    }
    
}
