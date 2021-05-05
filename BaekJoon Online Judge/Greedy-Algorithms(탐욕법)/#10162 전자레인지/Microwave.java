/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.BOJ10162;

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
        int t = sc.nextInt();
        int[] botton = {300, 60, 10};
        int cnt_a = 0, cnt_b = 0, cnt_c = 0;
        
        
        if(t >= 300) {
            cnt_a = t / 300;
            t %= 300;
        }
        if(t >= 60){
            cnt_b = t / 60;
            t %= 60;
        }
        if(t >= 10){
            cnt_c = t / 10;
            t %= 10;
        }
        
        if(t != 0) System.out.println("-1");
        else System.out.println(cnt_a + " " + cnt_b + " " + cnt_c);
    }
    
}
