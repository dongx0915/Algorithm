/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiOrPlust;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    public static int getMax(String input){
        int[] num = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            num[i] = input.charAt(i) - '0';
        }
        Arrays.sort(num);
        
        int result = num[0];
        
        for (int i = 1; i < input.length(); i++) {
            if(result == 0 || num[i] == 1) result += num[i];
            else result *= num[i];
        }
        
        return result;
    }
    
    public static int getMax2(String input){
        int result = input.charAt(0) - '0';
        
        for (int i = 1; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            if(result <= 1 || num <= 1) result += num;
            else result *= num;
        }
        
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(getMax2(input));
    }
    
}
