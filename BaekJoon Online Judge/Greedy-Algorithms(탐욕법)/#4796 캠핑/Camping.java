/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon4796;

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
        int l,p,v;
        
        for (int i = 1;; i++) {
            l = sc.nextInt(); //사용가능 일 수
            p = sc.nextInt(); //연속하는 일 수
            v = sc.nextInt(); //휴가
            
            if(l == 0 && p == 0 && v == 0) break;
            //남은 일 수가 사용가능 일 수보다 작으면 그대로 출력
            //남은 일 수가 사용가능 일 수보다 많으면 사용가능 수를 출력
            int result = (v/p) * l + ((l < (v % p)) ? l : (v % p));
            
            System.out.println("Case " + i + ": " + result);
        }
    }
    
}
