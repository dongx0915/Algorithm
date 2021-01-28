/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class AdventurerGuild {

    public static int getMaxGroup(int n, int[] fear){
        int group = 0;
        int now_group = 0;
        
        for (int i = 0; i < n; i++) {
            now_group++;
            if(fear[i] <= now_group){
                group++;
                now_group = 0;
            }
        }
        return group;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] fear = new int[n];
        for (int i = 0; i < n; i++) {
            fear[i] = sc.nextInt();
        }
        
        Arrays.sort(fear);
        System.out.println(getMaxGroup(n, fear));
    }
    
}
