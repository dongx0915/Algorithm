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
    
    /*
    * ( : 40
    * ) : 41
    * [ : 91
    * ] : 93
    */
    public static String isPairString(String str){
        Stack<Character> s = new Stack<>();
        char ch;
        
        for (int i = 0; i < str.length(); i++) {
            switch(ch = str.charAt(i)){
                case '(':
                case '[':
                    s.push(ch);
                    break;
                case ')':
                case ']':
                    if(s.isEmpty()) return "no";
                    if(ch == ')' && s.peek() != '(') return "no";
                    if(ch == ']' && s.peek() != '[') return "no";
                    s.pop();
                    break;
            }
        }
                
        return s.isEmpty() ? "yes" : "no";
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
