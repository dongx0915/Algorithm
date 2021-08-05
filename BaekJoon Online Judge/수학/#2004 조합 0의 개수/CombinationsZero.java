/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math.BOJ2004;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int multiplier(int n, int multi){
        int cnt = 0;
        
        while(n >= multi){
            cnt += n / multi;
            n /= multi;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int mul2 = multiplier(n, 2) - multiplier(m, 2) - multiplier(n-m, 2);
        int mul5 = multiplier(n, 5) - multiplier(m, 5) - multiplier(n-m, 5);
        
        System.out.println(Math.min(mul2, mul5));
    }
    
}
