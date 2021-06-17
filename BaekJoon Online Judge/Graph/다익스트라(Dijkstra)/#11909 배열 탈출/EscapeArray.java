/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.BOJ11909;

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
    public static int[][] array;
    public static final int MAX = Integer.MAX_VALUE;
    
    public static int getMinCost(int n){
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(cost[i], MAX);
        
        cost[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i + 1 < n){      //아래로 갈 수 있는 경우
                    if(array[i][j] > array[i + 1][j]) cost[i + 1][j] = Math.min(cost[i + 1][j], cost[i][j]);
                    else cost[i + 1][j] = Math.min(cost[i + 1][j], cost[i][j] + (array[i + 1][j] - array[i][j]) + 1);
                }
                if(j + 1 < n){      //오른쪽으로 갈 수 있는 경우
                    if(array[i][j] > array[i][j + 1]) cost[i][j + 1] = Math.min(cost[i][j + 1], cost[i][j]);
                    else cost[i][j + 1] = Math.min(cost[i][j + 1], cost[i][j] + (array[i][j + 1] - array[i][j]) + 1);
                }      
            }
        }
        
        return cost[n - 1][n - 1];
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        array = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            
            for (int j = 0; input.hasMoreTokens(); j++) array[i][j] = Integer.parseInt(input.nextToken());
        }
        
        System.out.println(getMinCost(n));
    }
    
}
