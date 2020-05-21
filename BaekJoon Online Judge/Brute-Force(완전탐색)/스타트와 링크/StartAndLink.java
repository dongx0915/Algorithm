/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MSI
 */ 
public class StartAndLink {
    public static int[][] abillity;
    public static int[] player;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;
    
    public static int getSumDiffrent(ArrayList<Integer> picked, int pickCnt){
        int sum1 = 0, sum2 = 0;
        int[] TeamStart = new int[(pickCnt / 2) + 1];
        int[] TeamLink = new int[(pickCnt / 2) + 1];
        
        for(int i = 0; i < pickCnt / 2; i++){
            TeamStart[i] = picked.get(i);
        }
        TeamStart[pickCnt / 2] = picked.get(0);
        
        for (int i = 0; i < pickCnt / 2; i++) {
            TeamLink[i] = picked.get(i + (pickCnt / 2));
        }
        TeamLink[pickCnt / 2] = picked.get(pickCnt / 2);
//        
//        for (int i : TeamLink) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//        
//        for (int i : TeamStart) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//        System.out.println("");
            
        for (int i = 0; i < pickCnt / 2; i++) {
            sum1 += (TeamStart[i] + TeamStart[i + 1]);
        }
    
        
        for (int i = 0; i < pickCnt / 2; i++) {
            sum2 += (TeamLink[i] + TeamLink[i + 1]);
        }
            
        return Math.abs(sum1 - sum2);
    }
    
    public static void print(ArrayList<Integer> picked){
        picked.forEach((s)->{
            System.out.print(s + " ");
        });
        System.out.println("");
    }
    
    public static void combination(ArrayList<Integer> picked, int pickCnt){
        if(picked.size() == pickCnt){
            int result = getSumDiffrent(picked, pickCnt);
            min = Integer.min(min, result);
            //print(picked);
            return;
        }
        
        int last = picked.isEmpty() ? -1 : picked.get(picked.size() - 1);
        
        for (int i = 0; i < pickCnt; i++) {
            if(!visit[i]){
                visit[i] = true;
                picked.add(i);
                
                combination(picked, pickCnt);
                
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
        player = new int[n];
        visit = new boolean[n];
        
        ArrayList<Integer> picked = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            player[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                abillity[i][j] = sc.nextInt();
            }
        }
        
        combination(picked, n);
        System.out.println(min);
    }
    
}
