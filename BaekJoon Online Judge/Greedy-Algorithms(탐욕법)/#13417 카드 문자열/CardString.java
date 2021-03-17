/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon13417;

import java.util.ArrayDeque;
import java.util.Deque;
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
    
    public static String getFirstString(String input){
        Deque<Character> dq = new ArrayDeque<>();
        StringJoiner result = new StringJoiner("");
        char[] alpha = input.toCharArray();
        
        dq.offerFirst(alpha[0]);
        
        for (int i = 1; i < alpha.length; i++) {
            if(dq.peekFirst() >= alpha[i]) dq.offerFirst(alpha[i]);
            else dq.offerLast(alpha[i]);
        }
        
        while(!dq.isEmpty()) result.add(dq.pollFirst() + "");
        return result.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int n;
        while (test-- != 0) {
            n = sc.nextInt();
            
            String input = sc.useDelimiter("\n").next().replaceAll(" ", "");
            System.out.println(getFirstString(input));
        }
    }
}
