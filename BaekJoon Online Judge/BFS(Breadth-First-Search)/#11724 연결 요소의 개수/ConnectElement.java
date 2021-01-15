/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author W44858
 */

public class Element {

    /**
     * @param args the command line arguments
     */
    
    public static int vortex;       // N
    public static int edge;         // M
    public static int[][] adjacent; // adjacent matrixt
    public static boolean[] visited;
    
    public static int bfs(int root){
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (int i = 1; i < vortex + 1; i++) {
                if(adjacent[now][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;                      //enqueue하면서 같이 visited 체크를 해줘야 반복 횟수가 줄어듦(dequeue하면서 방문체크하면 시간초과남)
                }
            }
        }
        
        return 1;
    }
    
    public static int getConnectionNode(){
        int connected = 0;
        
        for (int i = 1; i < vortex + 1; i++) {
            if(!visited[i]) {
                connected += bfs(i);
            }
        }
        
        return connected;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        vortex = sc.nextInt();
        edge = sc.nextInt();
        adjacent = new int[vortex + 1][vortex + 1];
        visited = new boolean[vortex + 1];
        
        for (int i = 0; i < edge; i++) {
            int d1= sc.nextInt();
            int d2= sc.nextInt();
            adjacent[d1][d2] = adjacent[d2][d1] = 1;
        }
        for (int i = 1; i < vortex + 1; i++) {
            adjacent[i][i] = 1;
        }
        System.out.println(getConnectionNode());
    }
    
}
