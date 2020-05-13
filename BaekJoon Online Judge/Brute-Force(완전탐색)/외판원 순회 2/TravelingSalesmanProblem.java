/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DongHyeon Kim <20183188>
 */

public class TravelingSalesmanProblem {
    static int min = Integer.MAX_VALUE;
    static int[][] sideCity;
    
    public static void printPick(ArrayList<Integer> picked){
        picked.forEach((s) -> {
            System.out.printf("%d ", s);
        });
        System.out.println("");
    }
    
    public static int getCost(ArrayList<Integer> picked){
        int costSum = 0;
        int size = picked.size();
        picked.add(picked.get(0));
        
        for (int i = 0; i < size; i++) {
            int nowCost = sideCity[picked.get(i)][picked.get(i + 1)];
            if(((int)picked.get(i) != (int)picked.get(i + 1)) && nowCost == 0){
                picked.remove(picked.size() - 1);
                return -1;
            }
            
            if(nowCost != 0) costSum += nowCost;
        }
        picked.remove(picked.size()-1);
        return costSum;
    }
    
    public static void permutation(int[] city, boolean[] visit, ArrayList<Integer> picked, int n){
        
        if(picked.size() == n){
            //printPick(picked);
            int thisMin = getCost(picked);
            if(thisMin == -1) return;
            if(min > thisMin) min = thisMin;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visit[i]){
                visit[i] = true;
                picked.add(city[i]);
                
                permutation(city, visit, picked, n);
                
                visit[i] = false;
                picked.remove(picked.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] city = new int[n]; // Restore Permutation 
        boolean[] visit = new boolean[n];
        sideCity = new int[n][n];
        ArrayList<Integer> picked = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            city[i] = i;
            for (int j = 0; j < n; j++) {
                sideCity[i][j] = sc.nextInt();
            }
        }

        permutation(city, visit, picked, n);
        System.out.println(min);
    }
    
}
