/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class2.BOJ4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static String isPairString(String str){
        int square = 0;
        int round = 0;
        boolean prev = false;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(round < 0 || square < 0) return "no";
            
            switch (ch) {
                case '[': square++; break;
                case ']': square--; break;
                case '(': round++;  break;
                case ')': round--;  break;
                default : break;
            }
            
            if(ch == '[' || ch == ']') prev = false;
            else if(ch == '(' || ch == ')') prev = true;
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
