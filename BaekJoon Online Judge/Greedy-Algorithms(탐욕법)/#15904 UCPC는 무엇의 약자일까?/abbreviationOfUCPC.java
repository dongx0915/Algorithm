/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.BOJ15904;

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
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String input = sc.next();
        int length = input.length();
        char[] ucpc = {'U','C','P','C'};
        int index = 0;
        
        for (int i = 0; i < length; i++) {
            if(index >= 4) break;
            if(input.charAt(i) == ucpc[index]){
                index++;
            }
        }
        
        if(index == 4) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
    }
}
