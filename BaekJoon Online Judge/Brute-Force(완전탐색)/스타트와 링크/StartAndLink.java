/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 스타트와 링크 https://www.acmicpc.net/problem/14889
 * @author MSI
 */ 

public class StartAndLink {
    public static int[][] abillity;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;
    
    public static int getSumDiffrent(ArrayList<Integer> picked, int pickCnt){
        int sum1 = 0, sum2 = 0, index = 0;
        int[] TeamStart = new int[pickCnt];
        int[] TeamLink = new int[pickCnt];
        
        for (int i = 0; i < pickCnt; i++) TeamStart[i] = picked.get(i);
        for(int j = 0; j < pickCnt * 2; j++)if(!visit[j]) TeamLink[index++] = j;
        
        
        for(int i = 0; i < pickCnt - 1; i++){
            for(int j = i + 1; j < pickCnt; j++){
                sum1 += abillity[TeamStart[i]][TeamStart[j]] + abillity[TeamStart[j]][TeamStart[i]];
                sum2 += abillity[TeamLink[i]][TeamLink[j]] + abillity[TeamLink[j]][TeamLink[i]];
            }
        }

        return Math.abs(sum1 - sum2);
    }

    public static void combination(ArrayList<Integer> picked, int n, int pickCnt){
        if(picked.size() == pickCnt){
            min = Integer.min(min, getSumDiffrent(picked, pickCnt));
            //print(picked);
            return;
        }
        
        int last = picked.isEmpty() ? -1 : picked.get(picked.size() - 1);
        
        for (int i = 0; i < n; i++) {
            if(!visit[i] && last < i){
                visit[i] = true;
                picked.add(i);
                
                combination(picked, n, pickCnt);
                
                visit[i] = false;
                picked.remove(picked.get(picked.size()-1));
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 선수의 수
        abillity = new int[n][n];
        visit = new boolean[n];
        
        ArrayList<Integer> picked = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                abillity[i][j] = sc.nextInt();
            }
        }
        
        combination(picked, n, n / 2);
        System.out.println(min);
    }
    
}
