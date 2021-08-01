/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ1956;

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
    public static final int INF = (400 * 399 * 10000) + 1; // V * E * dis
    public static int[][] road;
    public static int[] parent;
    
    public static int getParent(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x], parent);
    }
    
    public static void unionParent(int x, int y, int[] parent){
        //x -> y 방향으로 합침
        parent[x] = getParent(y, parent);
    }
    
    public static boolean isCylce(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        return x == y;
    }
    
    public static void floyd(int V){
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if(j == i || k == i || j == k) continue;
                    road[j][k] = Math.min(road[j][k], road[j][i] + road[i][k]);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        road = new int[V][V];
        parent = new int[V];
        
        
        for (int i = 0; i < V; i++) {
            Arrays.fill(road[i], INF);
            parent[i] = i;
        }
        
                for (int i : parent) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            road[n1][n2] =  Integer.parseInt(st.nextToken());
            
            unionParent(n1, n2, parent);
        }
        
        for (int i : parent) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
}
