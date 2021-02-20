/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon3098;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */

public class Main {
    
    public static void print(int[][] friendship){
        for (int i = 1; i < friendship.length; i++) {
            for (int j = 1; j < friendship.length; j++) {
                System.out.printf(" %2d", friendship[i][j]); 
           }
            System.out.println("");
        }
        
        System.out.println("");
    }
    
    public static int getNewFriendShips(int root, int day, int[][] friendship){
        int n = friendship.length;
        int new_fs = 0;
        
        
        for (int i = 1; i < n; i++) {
            if(friendship[root][i] != -1 && friendship[root][i] <= day){         //root와 i가 현재 날짜 이전에 친구였던 사이라면
                //cur_friends.add(i);
                for (int j = 1; j < n; j++) {   //i의 친구를 root의 친구에 추가한다.
                    //System.out.println("i = " + i + " j = " + j);
                    if(j == root) continue;
                    if(friendship[i][j] == day){
                        if(friendship[j][root] >= 0) continue;
                        //System.out.println(root + "와 " + j + "가 친구가 됨");
                        friendship[root][j] = friendship[j][root] = day + 1;
                        new_fs++;                   
                    }
                }
            }
        }
        
        return new_fs;
    }
    
    public static void calc_friendship(int n, int[][] friendship){
        StringBuilder sb = new StringBuilder();
        int day = 0;
        
        //새로운 관계가 하나도 안생기면 모두 친구가 된 것
        while(true){
            int new_fs = 0;
            //System.out.println("현재 날짜 : " + day);
            for (int i = 1; i < n + 1; i++) {
                new_fs += getNewFriendShips(i, day, friendship);
            }
            //print(friendship);
            //System.out.println("");
            if(new_fs == 0) break;
            sb.append(new_fs).append("\n");
            day++;
        }
        //}
        
        System.out.println(day);
        System.out.print(sb.toString());
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fs_cnt = sc.nextInt();
        int[][] friendship = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(friendship[i], -1);
        }
        
        
        for (int i = 0; i < fs_cnt; i++) {
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            friendship[f1][f2] = friendship[f2][f1] = 0;
        }
        
        //print(friendship);
        calc_friendship(n, friendship);
    }
    
}
