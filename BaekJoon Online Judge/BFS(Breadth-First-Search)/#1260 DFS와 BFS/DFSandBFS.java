/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class DFSandBFS {

    /**
     * @param args the command line arguments
     */
    
    static int vortex;                      //정점의 개수                  
    static int edge;                        //간선의 개수
    static int root;                        //시작할 노드(루트 노드)
    static int[][] adjacent;                //인접 행렬 (ArrayList[] 타입으로도 표현해보기)
    static boolean[] visited;
    
    public static ArrayList<Integer> BFS(){
        ArrayList<Integer> print = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;
        
        while(!q.isEmpty()){
            int nowNode = q.poll();
            
            print.add(nowNode);              //방문하는 즉시 출력
            
            for (int i = 0; i < vortex + 1; i++) {
                if(visited[i] == false && adjacent[nowNode][i] == 1){      //현재 노드랑 연결되어있는 노드이면
                    q.add(i);   
                    visited[i] = true;
                }
            }
        }
        
        return print;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        vortex = sc.nextInt();
        edge = sc.nextInt();
        root = sc.nextInt();
        
        adjacent = new int[vortex + 1][vortex + 1];
        visited = new boolean[vortex + 1];
        
        for (int i = 0; i < edge; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            adjacent[node1][node2] = 1;
            adjacent[node2][node1] = 1;
        }
        
//        for (int i = 0; i < vortex + 1; i++) {
//            for (int j = 0; j < vortex + 1; j++) {
//                System.out.print(adjacent[i][j] + " ");
//            }
//            System.out.println("");
//        }
        BFS();
    }
    
}
