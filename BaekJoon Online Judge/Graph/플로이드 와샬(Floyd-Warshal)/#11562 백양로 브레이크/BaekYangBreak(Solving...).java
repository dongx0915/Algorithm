/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ11562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 10000000;
    public static int N,M;
    public static int[][] road;
    
    public static void floyd(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == i || k == i || j == k) continue;
                    int r1 = road[j][i] == INF ? 1 : 0;
                    int r2 = road[i][k] == INF ? 1 : 0;
                    road[j][k] = r1 + r2;
                }
            }
        }
    }
    
    public static void print(){
        for (int[] ls : road) {
            for (int l : ls) {
                if(l == INF) System.out.print("INF ");
                else System.out.printf("%4d", l);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        road = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(road[i], INF);
            road[i][i] = 0;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            
            if(d == 0) road[n1][n2] = 1;
            else if(d == 1) road[n1][n2] = road[n2][n1] = 1;
        }
        
        print();
        floyd();
        print();
        
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            
        }
    }
    
}
