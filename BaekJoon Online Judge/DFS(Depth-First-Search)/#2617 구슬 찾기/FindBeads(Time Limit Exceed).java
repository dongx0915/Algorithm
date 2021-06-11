/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ2617;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node{
    int index_;
    ArrayList<Integer> heavybeads_ = new ArrayList<>();
    ArrayList<Integer> lightbeads_ = new ArrayList<>();

    public Node(int index_) {
        this.index_ = index_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N, M;
    public static Node[] beads;
            
    public static void dfs(int root, int now){
        int size = beads[now].lightbeads_.size();
        
        for (int i = 0; i < size; i++) {
            int next = beads[now].lightbeads_.get(i);
            if(!beads[next].heavybeads_.contains(root)) beads[next].heavybeads_.add(root);
            dfs(root, next);
        }
        

//        for (Integer next : beads[root].lightbeads_) {
//            beads[next].heavybeads_.addAll(beads[root].lightbeads_);
//            dfs(next);
//            beads[root].lightbeads_.addAll(beads[next].heavybeads_);   
//           /*  이러면 beads[root].lightbeads_의 사이즈가 바뀌게 되므로
//            * Enhanced for문의 반복 범위가 달라질 수 있다.
//            * 이 때문에 ConcurrentModificationException이 발생한다.
//            */
//        }
    }

    public static void rev_dfs(int root, int now){
        int size = beads[now].heavybeads_.size();
        
        for (int i = 0; i < size; i++) {
            int next = beads[now].heavybeads_.get(i);
            if(!beads[next].lightbeads_.contains(root))beads[next].lightbeads_.add(root);
            rev_dfs(root, next);
        }
    }
        
    public static int getNotMiddleBeads(){
        int notMiddleBeads = 0;
        for (int i = 1; i < N + 1; i++) dfs(i,i);
        for (int i = 1; i < N + 1; i++) rev_dfs(i,i);
        
        //printBeads();
        
        for (int i = 1; i < N + 1; i++) {
            int heavy = beads[i].heavybeads_.size();
            int light = beads[i].lightbeads_.size();
            
            if(((N + 1) / 2) <= (heavy + light)) if(heavy != light) notMiddleBeads++;
        }
        
        return notMiddleBeads;
    }
    
    public static void printBeads(){
        for (int i = 1; i < N + 1; i++) {
            //System.out.println(i + " 번 : heavy = " + beads[i].heavybeads_.size() + " light = " + beads[i].lightbeads_.size());
            System.out.println(i + "번 ");
            System.out.println("heavy : ");
            for (Integer integer : beads[i].heavybeads_) {
                System.out.print(integer + " ");
            }
            
            System.out.println("\nlight : ");
            for (Integer integer : beads[i].lightbeads_) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       //구슬의 개수
        M = sc.nextInt();       //비교 쌍의 개수

        beads = new Node[N + 1];
        
        for (int i = 1; i < N + 1; i++) beads[i] = new Node(i);
        for (int i = 0; i < M; i++) beads[sc.nextInt()].lightbeads_.add(sc.nextInt());
        
        System.out.println(getNotMiddleBeads());
    }
    
}
