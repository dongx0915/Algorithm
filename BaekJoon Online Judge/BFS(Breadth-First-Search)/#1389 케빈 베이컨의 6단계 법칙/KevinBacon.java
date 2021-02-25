/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon1389;

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
    
    public static int bfs(int user, int friend, int[][] friendship){
        int bacon = 1;
        boolean[] visited = new boolean[friendship.length]; //user + 1
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> cnt_q = new LinkedList<>();
        q.add(user);
        cnt_q.add(bacon);
        visited[user] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            bacon = cnt_q.poll();

            for (int i = 1; i < friendship.length; i++) {
                if(!visited[i] && friendship[now][i] == 1){
                    if(i == friend) return bacon;
                    q.add(i);
                    cnt_q.add(bacon + 1);
                    visited[i] = true;
                }
            }
        }
        
        return bacon;
    }
    
    public static int getKevinBakern(int user, int[][] friendship){
        int min_kv = Integer.MAX_VALUE;
        int min_user = 0;
        
        for (int i = 1; i < user + 1; i++) {
            int bacon = 0;
            for (int j = 1; j < user + 1; j++) {
                if(i == j) continue;
                bacon += bfs(i, j, friendship);
            }

            if(min_kv == bacon){
                min_user = Math.min(min_user, i);
            }
            else if(min_kv > bacon){
                min_kv = bacon;
                min_user = i;
            }
        }
        
        return min_user;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int user = sc.nextInt();
        int fs = sc.nextInt();
        int[][] friendship = new int[user + 1][user + 1];
        
        for (int i = 0; i < fs; i++) {
            int u1 = sc.nextInt();
            int u2 = sc.nextInt();
            friendship[u1][u2] = friendship[u2][u1] = 1;
        }

        System.out.println(getKevinBakern(user, friendship));
    }
    
}
