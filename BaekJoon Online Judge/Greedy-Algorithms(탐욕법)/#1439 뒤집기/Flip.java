/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.BOJ1439;

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
        String str = sc.next();
        
        int[] area = new int[2];
        int length = str.length();
        
        area[str.charAt(0) - '0']++;
        
        for (int i = 1; i < length; i++) if(str.charAt(i - 1) != str.charAt(i)) area[str.charAt(i) - '0']++;
        
        if(area[0] >= area[1]) System.out.println(area[1]);
        else System.out.println(area[0]);
    }
    
}
