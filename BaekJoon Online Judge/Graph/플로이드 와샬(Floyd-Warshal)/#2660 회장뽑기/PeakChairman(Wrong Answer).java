/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 1000;
    public static int[][] friends;
    
    public static void print(){
        for (int[] friend : friends) {
            for (int i : friend) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void floyd(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == i || k == i || j == k) continue;
                    friends[j][k] = Math.min(friends[j][k], friends[j][i] + friends[i][k]);
                }
            }
        }
    }
    
    public static String getCandidate(int n){
        class Rank implements Comparable<Rank>{
            int index_;
            int score_ = 0;
            public Rank(int i){
                this.index_ = i;
            }
            @Override
            public int compareTo(Rank r){
                if(this.score_ == r.score_) return this.index_ - r.index_;
                return this.score_ - r.score_;
            }
        }
        
        PriorityQueue<Rank> pq = new PriorityQueue<>();
        StringJoiner result = new StringJoiner(" ");
        
        
        for (int i = 0; i < n; i++) {
            Rank r = new Rank(i + 1);
            
            for (int j = 0; j < n; j++) {
                if(friends[i][j] == INF) continue;
                r.score_ = Math.max(r.score_, friends[i][j]);
            }
            pq.offer(r);
        }

        Rank prev = pq.isEmpty() ? null : pq.peek();
        
        System.out.print(prev.score_ + " ");
        
        while(!pq.isEmpty()){
            if(prev.score_ != pq.peek().score_) break;
            
            prev = pq.poll();
            result.add(prev.index_ + "");
        }
        
        System.out.println(result.toString().replaceAll(" ","").length());
        return result.toString();
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        friends = new int[n][n];
        
        for (int i = 0; i < n; i++) Arrays.fill(friends[i], INF);
        for (int i = 0; i < n; i++) friends[i][i] = 0;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            if(n1 == -2 && n2 == -2) break;
            if(n1 == n2) continue;
            
            friends[n1][n2] = friends[n2][n1] = 1;
        }
        
        floyd(n);
        //print();
        System.out.println(getCandidate(n));
    }
    
}
