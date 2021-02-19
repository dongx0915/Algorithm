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
    int num;
    ArrayList<Integer> adjacent = new ArrayList<>();

    public Node(int num) {
        this.num = num;
    }
    
}

public class Main {
    public static void addEdge(Node n1, Node n2){
        if(!n1.adjacent.contains(n2.num)) n1.adjacent.add(n2.num);
        if(!n2.adjacent.contains(n1.num)) n2.adjacent.add(n1.num);
    }
    
    public static int getKinship(int p1, int p2, Node[] person){
        boolean[] visited = new boolean[person.length];
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> kinship = new LinkedList<>();
        int cnt = 0;
        q.add(p1);
        kinship.add(cnt);
        visited[p1] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            cnt = kinship.poll();
            
            for (Integer child : person[now].adjacent) {
                if(!visited[child]){
                    if(child == p2) return cnt + 1;
                    q.add(child);
                    kinship.add(cnt + 1);
                    visited[child] = true;
                }
            }
        }
       
        return -1;
    } 
    
    public static void printStatus(Node[] person, int n){
        for (int i = 1; i < n + 1; i++) {
            System.out.println(i + "번 사람");
            for (Integer child : person[i].adjacent) {
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
            person[i] = new Node(i);
        }
        
        for (int i = 0; i < m; i++) {
            addEdge(person[sc.nextInt()], person[sc.nextInt()]);
        }
        
        //printStatus(person, n);
        
        System.out.println(getKinship(p1,p2,person));
    }
    
}
