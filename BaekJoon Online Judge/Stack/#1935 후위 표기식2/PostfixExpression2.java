/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.BOJ1935;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] value = new int[26];
    
    public static double resultTheExp(String exp, Stack<Double> stack){
        int length = exp.length();
        
        for (int i = 0; i < length; i++) {
            char now = exp.charAt(i);
            
            if('A' <= now && now <= 'Z') stack.push((double)value[(int)(now - 'A')]);
            else {
                double n1 = stack.pop();
                double n2 = stack.pop();
                
                switch(now){
                    case '+' : 
                        stack.push(n2 + n1);
                        break;
                    case '-' : 
                        stack.push(n2 - n1);
                        break;
                    case '*' : 
                        stack.push(n2 * n1);
                        break;
                    case '/' : 
                        stack.push(n2 / n1);    //n1이 0인 경우 고려
                        break;
                }
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String exp = sc.next();
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) value[i] = sc.nextInt();
        
        System.out.printf("%.2f\n", resultTheExp(exp, stack));
    }
    
}
