/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ15829;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();

        long hash = 0;
        long r = 1;
        long mod = 1234567891;
        
        for (int i = 0; i < L; i++){
            hash += ((str.charAt(i)-'a'+1) * r) % mod;
            r = (r * 31) % mod;
        }
        
        System.out.println(hash % mod);
    }
    
}
