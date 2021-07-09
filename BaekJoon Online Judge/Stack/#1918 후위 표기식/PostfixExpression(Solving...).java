/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack.BOJ1918;

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
    public static String convertPreExpToPostExp(String exp){
        Stack<Character> s = new Stack<>();
        StringBuilder result = new StringBuilder();
        int length = exp.length();
        
        /*
        * 42 : *
        * 43 : +
        * 45 : -
        * 47 : /
        */
        
        for (int i = 0; i < length; i++) {
            char now = exp.charAt(i);
            if('A' <= now && now <= 'Z') result.append(now);
            else{
                if(s.isEmpty()) s.push(now);
                else if(now == '(') s.push(now);
                else if(now == ')') {
                    while(s.peek() != '(') result.append(s.pop());
                    s.pop();
                }
                else if(now == '*' || now == '/'){
                    char top = s.peek();
                        
                    if(top == '*' || top == '/') result.append(s.pop());
                    s.push(now);
                }
                else if(now == '+' || now == '-'){
                    result.append(s.pop());
                    s.push(now);
                }
            }
            System.out.println(result.toString());
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String exp = new Scanner(System.in).next();
        
        System.out.println(convertPreExpToPostExp(exp));
    }
    
}
