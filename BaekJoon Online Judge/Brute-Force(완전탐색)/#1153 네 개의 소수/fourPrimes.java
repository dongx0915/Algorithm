/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Gold.BOJ1153;

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
    public static boolean[] prime;
    public static StringJoiner sj;
    
    public static void checkPrime(int n){
        // 소수가 아니면 true
        prime[0] = prime[1] = true;
        
        for(int i = 2; i * i <= n; i++){
            if(!prime[i]){
                for(int j = i * i; j<=n; j+=i) prime[j] = true;
            }
        }
    }
    
    /* remain : 남은 값, selected : 선택한 개수 */
    public static boolean selectPrimes(int[] ans, int remain, int selected){
        if(selected == 3){
            if(!prime[remain]) {
                ans[selected] = remain;
                
                for (int an : ans) sj.add(an + "");
                return true;
            }
            return false;
        }
        
        for (int i = 2; i < remain; i++) {
            if(!prime[i]){
                ans[selected] = i;
                if(selectPrimes(ans, remain - i, selected + 1)) return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] ans = new int[4];
        prime = new boolean[n+1];
        sj = new StringJoiner(" ");
        
        checkPrime(n);
        boolean result = selectPrimes(ans, n, 0);
        
        if(result) System.out.println(sj.toString());
        else System.out.println("-1");
    }
}
