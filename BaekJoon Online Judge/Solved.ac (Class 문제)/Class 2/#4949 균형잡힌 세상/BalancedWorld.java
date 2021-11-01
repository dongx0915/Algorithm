/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class2.BOJ4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static String isPairString(String str){
        Stack<Character> s = new Stack<>();
        int square = 0, round = 0;
        char ch, prev = ' ';
        
        for (int i = 0; i < str.length(); i++) {
            if(round < 0 || square < 0) return "no";
            
            switch (ch = str.charAt(i)) {
                case '(':
                case '[': 
                    s.push((prev = ch));
                    
                    if(ch == '[') square++; 
                    else round++;
                    break;
                case ')':
                    if(prev != '(' && prev != ' ') return "no";
                    if(!s.isEmpty()){
                        s.pop();
                        prev = s.isEmpty() ? ' ' : s.peek();
                    }
                    
                    round--;
                    break;
                case ']': 
                    if(prev != '[' && prev != ' ') return "no";
                    if(!s.isEmpty()) {
                        s.pop();
                        prev = s.isEmpty() ? ' ' : s.peek();
                    }
                    
                    square--;
                    break;
            }
        }
                
        return (round == 0 && square == 0) ? "yes" : "no";
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        
        while(!(str = br.readLine()).equals(".")){
            System.out.println(isPairString(str));
        }
    }
    
}
