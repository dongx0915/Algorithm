/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ1644;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Integer> getPrime(int N){
        boolean[] prime = new boolean[N+1];
        
        //소수는 false
        prime[0] = prime[1] = true;
        
        for (int i = 2; i*i <= N; i++) {
            if(!prime[i]){
                for (int j = i*i; j <= N; j+=i) prime[j] = true;
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) if(!prime[i]) primes.add(i);
        
        return primes;
    }
    
    public static int getCases(int N, ArrayList<Integer> prime){
        int s = 0, e = 0;
        int sum = 0, cnt = 0;
        int size = prime.size();
        
        for (s = 0; s < size; s++) {
            while(sum < N && e < size){
                sum += prime.get(e++);
            }
            if(sum == N) cnt++;
            sum -= prime.get(s);
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        ArrayList<Integer> prime = getPrime(N);
        
        System.out.println(getCases(N, prime));
    }
    
}
