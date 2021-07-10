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
        int[] oper = {1,0,-1,0,-1,1}; //{*, +, _, -, _, /} (_는 빈 칸)
        
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
                else{ //연산자인 경우
                    //현재 연산자의 우선순위가 스택의 Top의 연산자보다 높거나 같을 때까지 Pop
                    // -> 스택의 top에 현재 연산자보다 우선순위가 낮은 연산자가 나올 때까지 Pop
                    while (!s.isEmpty() &&  s.peek() != '(' && oper[now - '*'] <= oper[s.peek() - '*']) result.append(s.pop());
                    s.push(now);
                }
            }
        }
        
        while(!s.isEmpty()) result.append(s.pop());
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String exp = new Scanner(System.in).next();

        System.out.println(convertPreExpToPostExp(exp));
    }
    
}
