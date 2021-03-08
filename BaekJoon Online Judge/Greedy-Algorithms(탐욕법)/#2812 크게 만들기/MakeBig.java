/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon2812;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {
    
    public static String getMaxNum(String num, int k){
        Stack<Character> s = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < num.length(); i++) {
            while(k != 0 && !s.isEmpty() && s.peek() - '0' < num.charAt(i) - '0'){
                    s.pop();
                    k--;
            }
            s.push(num.charAt(i));
        }
        
        int lange = s.size() - k;
        for (int i = 0; i < lange; i++) result.append(s.get(i));
        return result.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        String num = sc.next();
        System.out.println(getMaxNum(num, k));
    }
    
}
