/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon.BipartiteGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        //if(!node[n2].adjcent.contains(n1)) node[n2].adjcent.add(n1);
    }
    
    public static boolean bfs(Node root){
//        boolean[] visited = new boolean[vortex + 1];
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
    
    public static void printNode(){
        for (Node node1 : node) {
            System.out.print(node1.vortex + " : ");
            
            for (Integer integer : node1.adjcent) {
                System.out.print(integer + "[" + node[integer].color + "] ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        test = Integer.parseInt(br.readLine());
        
        while(test-- != 0){
            String[] input = br.readLine().split(" ");
            vortex = Integer.parseInt(input[0]);
            edge = Integer.parseInt(input[1]);
            
            node = new Node[vortex + 1];
            visited = new boolean[vortex + 1];
            for (int i = 0; i < vortex + 1; i++) {
                node[i] = new Node(i);
            }
            
            for (int i = 0; i < edge; i++) {
                input = br.readLine().split(" ");
                addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }
            System.out.println(isBipartiteGraph());
        }
    }
    
}
