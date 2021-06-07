/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ16432;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Integer>[] cake;
    public static int N;
    public static ArrayList<Integer> stolenCake = new ArrayList<>();
    
    public static boolean dfs(int day, int prev_cake){
        if(day == N + 1) return true;
        
        for (Integer next_cake : cake[day]) {
            if(next_cake == prev_cake) continue;
            
            stolenCake.add(next_cake);
            
            if(dfs(day + 1, next_cake)) return true;
            
            stolenCake.remove(stolenCake.size() - 1);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cake = new ArrayList[N + 1]; 
        
        //cake[날짜][떡 종류] 
        for (int i = 1; i < N + 1; i++) {
            int cake_cnt = sc.nextInt();
            cake[i] = new ArrayList<>();
            
            for (int j = 0; j < cake_cnt; j++) cake[i].add(sc.nextInt());
        }
        
        if(dfs(1, 0)) for (Integer cake : stolenCake) System.out.println(cake);
        else System.out.println("-1");
    }
    
}
