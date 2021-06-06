/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ2023;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N;
    
    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;

        for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;

        return true;
    }
    
    public static void dfs(int num, int len){
        if(len == N){
            System.out.println(num);
            return;
        }
        
        for (int i = 1; i <= 9; i+=2) {
            if(isPrime((num * 10) + i)) dfs((num * 10) + i, len + 1);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
        
    }
    
}
