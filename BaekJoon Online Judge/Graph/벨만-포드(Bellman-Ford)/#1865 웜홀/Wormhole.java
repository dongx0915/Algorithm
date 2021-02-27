/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon1865;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void printAdj(int[][] adj){
        for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj[0].length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static boolean bfs(int root, int[][] adj){
        int city = adj.length;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> time_q = new LinkedList<>();
        q.add(root);
        time_q.add(0);
        
        System.out.println("Root : " + root);
        
        while(!q.isEmpty()){
            int now = q.poll();
            int now_time = time_q.poll();
            
            for (int i = 1; i < city; i++) {
                if(adj[now][i] != 10000){
                    System.out.println("Add now : " + now + " i = " + i);
                    //시간이 줄어들면서 출발 위치로 돌아오는 것이 가능한 경우
                    if(i == root){
                        System.out.println("return now : " + now + " i = " + i);
                        System.out.println(now_time + adj[now][i]);
                        if((now_time + adj[now][i]) < 0) return true;
                        continue;
                    }
                    q.add(i);
                    time_q.add(now_time + adj[now][i]);
                }
            }
        }
        System.out.println("");
        return false;
    }
    
    public static void possibleToReturn(int city, int[][] adj){
        for (int i = 1; i < city + 1; i++) {
            if(bfs(i, adj)) System.out.println("YES");
        }
        System.out.println("NO");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int city = sc.nextInt();
            int road = sc.nextInt();
            int wormhole = sc.nextInt();

            int[][] adj = new int[city + 1][city + 1];

            for (int[] is : adj) {
                Arrays.fill(is, 10000);
            }

            for (int i = 0; i < road; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                adj[s][e] = adj[e][s] = sc.nextInt();
            }

            for (int i = 0; i < wormhole; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                adj[s][e] = sc.nextInt() * -1;
            }

            printAdj(adj);
            possibleToReturn(city, adj);
        }
    }
    
}
