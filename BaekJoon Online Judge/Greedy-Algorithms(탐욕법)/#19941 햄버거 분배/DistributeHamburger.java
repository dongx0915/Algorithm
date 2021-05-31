/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.BOJ19941;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int getEdiblePeople(StringBuilder table, int N, int K){
        int edible = 0;
        
        for (int i = 0; i < N; i++) {
            if(table.charAt(i) == 'P'){
                int start = (i - K >= 0) ? i - K : 0;
                boolean eat_flag = false;
                
                for (int j = start; j < i; j++) {
                    if(table.charAt(j) == 'H'){
                        table.setCharAt(j, 'E');
                        edible++;
                        eat_flag = true;
                        break;
                    }
                }
                
                if(!eat_flag){
                    int end = (i + K + 1) < N ? (i + K + 1) : N;
                    for (int j = i + 1; j < end; j++) {
                        if(table.charAt(j) == 'H'){
                            table.setCharAt(j, 'E');
                            edible++;
                            break;
                        }
                    }
                }
            }
        }
        
        return edible;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       //식탁의 길이
        int K = sc.nextInt();       //햄버거를 선택할 수 있는 거리
        
        StringBuilder table = new StringBuilder(sc.next());
        
        System.out.println(getEdiblePeople(table, N, K));
        
    }
    
}
