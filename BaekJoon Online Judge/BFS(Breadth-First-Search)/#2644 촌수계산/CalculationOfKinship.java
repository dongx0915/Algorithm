/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon2644;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node{
    ArrayList<Integer> childs = new ArrayList<>();
}
public class Main {
    
    public static int getKinship(int p1, int p2, Node[] person){
        Queue<Integer> q = new LinkedList<>();
        int kinship = 1;
        q.add(p1);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (Integer child : person[now].childs) {
                kinship++;
                if(child == p2) return kinship;
                q.add(child);
            }
        }
       
        return -1;
    } 
    
    public static void printStatus(Node[] person, int n){
        for (int i = 1; i < n + 1; i++) {
            System.out.println(i + "번 사람");
            for (Integer child : person[i].childs) {
                System.out.print(child + " ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //사람 수
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int m = sc.nextInt();
        
        Node[] person = new Node[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            person[i] = new Node();
        }
        
        for (int i = 0; i < m; i++) {
            person[sc.nextInt()].childs.add(sc.nextInt());
        }
        printStatus(person, n);
        
        System.out.println(getKinship(p1,p2,person));
    }
    
}
