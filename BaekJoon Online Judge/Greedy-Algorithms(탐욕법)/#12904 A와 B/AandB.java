/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.BOJ12904;

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
        String s = sc.next();
        StringBuilder t = new StringBuilder(sc.next());
        
        while(t.length() > 0){
            if(s.length() == t.length()){
                if(s.equals(t.toString())){
                    System.out.println("1");
                    System.exit(0);
                }
            }
            
            char c = t.charAt(t.length() - 1);
            t.deleteCharAt(t.length() - 1);
            
            if(c == 'B') t = t.reverse();
        }
        
        System.out.println("0");
    }
}
