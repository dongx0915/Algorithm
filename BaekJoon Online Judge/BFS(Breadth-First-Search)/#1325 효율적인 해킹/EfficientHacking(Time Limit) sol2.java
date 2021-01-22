/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EfficientHacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class EfficientHacking {

    /**
     * @param args the command line arguments
     */
    public static int N;    //컴퓨터 수
    public static int M;    //신뢰 관계
    public static int[] cnt;
    public static ArrayList<Integer>[] trust;
    
    public static int bfs(int root){
        int hack_cnt = 1;
        boolean[] visited = new boolean[N + 1];
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> hacked = new LinkedList<>();
        
        q.add(root);
        hacked.add(hack_cnt);
        visited[root] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            hack_cnt = hacked.poll();
            
            for (Integer com : trust[now]) {
                if(!visited[com]){
                    q.add(com);
                    hacked.add(hack_cnt + 1);
                    visited[com] = true;
                }
            }
        }
        
        return hack_cnt;
    }
    public static String getHackingCnt(){
        StringJoiner sj = new StringJoiner(" ");
        int max = -1;
        for (int i = 1; i < N + 1; i++) {
            cnt[i] = bfs(i);
            if(max < cnt[i]) max = cnt[i];
        }
        
        for (int i = 1; i < N + 1; i++) {
            if(cnt[i] == max) sj.add(i + "");
        }
        return sj.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        cnt = new int[N + 1];
        trust = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            trust[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            trust[t2].add(t1);
        }
        
        System.out.println(getHackingCnt());
    }
    
}
