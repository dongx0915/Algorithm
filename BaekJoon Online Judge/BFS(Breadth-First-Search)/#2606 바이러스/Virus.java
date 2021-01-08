/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Virus {

    /**
     * @param args the command line arguments
     */
    static int computer;
    static int edge;
    static int[][] adjacent;
    static boolean[] visited;
    
    public static void addEdge(int n1, int n2){
        adjacent[n1][n2] = adjacent[n2][n1] = 1;
    }
    
    public static int BFS(){
        int infection = 0;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            
            for (int i = 1; i <= computer; i++) {
                if(!visited[i] && adjacent[now][i] == 1){
                    q.add(i);
                    visited[i] = true;
                }
            }
            infection++;
        }
        
        return infection - 1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        computer = sc.nextInt();
        edge = sc.nextInt();
        visited = new boolean[computer + 1];
        adjacent = new int[computer + 1][computer + 1];
        
        for (int i = 0; i < edge; i++) {
            addEdge(sc.nextInt(), sc.nextInt());
        }
        
        System.out.println(BFS());
    }
    
}
