/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ16964;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node{
    int index_;
    int parent_ = 0;
    boolean visited_ = false;
    ArrayList<Integer> child = new ArrayList<>();

    public Node(int index_) {
        this.index_ = index_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static boolean isCorrectOrder(Node[] node, int[] order, int n){
        if(order[0] != 1) return false;
        
        //Stack<Integer> s = new Stack<>();
        //s.add(1);
        node[1].visited_ = true;

        int index = 0;
        int cur = 1;
        
        while(index < n){
            if(cur != order[index]){
                if(node[cur].parent_ == 0) return false;
                cur = node[cur].parent_;
            }
            else index++;
            
            for (Integer childs : node[cur].child) {        //현재 노드에서 방문 가능한 자식 노드가 있는지 찾음
                if(!node[childs].visited_ && childs == order[index]){
                    node[childs].visited_ = true;
                    cur = childs;
                }
            }
        }
        
        return true;
    }
    
    public static void printStack(Stack<Integer> s){
        System.out.print("스택 : ");
        for (Integer integer : s) {
            System.out.print(integer + " ");
        }
        System.out.println("");
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] node = new Node[n + 1];
        
        for (int i = 0; i < n + 1; i++) node[i] = new Node(i);
        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            if(!node[n1].child.contains(n2)){
                node[n1].child.add(n2);
                node[n2].parent_ = n1;
            }
        }
        
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = sc.nextInt();
        }
        
        if(isCorrectOrder(node, order, n)) System.out.println("1");
        else System.out.println("0");
    }
    
}
