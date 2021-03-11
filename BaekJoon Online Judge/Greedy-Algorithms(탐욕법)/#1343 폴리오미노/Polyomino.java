/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon1343;

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
        String board = sc.next();
        
        board = board.replaceAll("XXXX", "AAAA");
        board = board.replaceAll("XX", "BB");
        
        if(board.contains("X")) System.out.println("-1");
        else System.out.println(board);
    }
}
