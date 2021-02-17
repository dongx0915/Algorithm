/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon2458;

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
    ArrayList<Integer> taller = new ArrayList<>();
    ArrayList<Integer> shorter = new ArrayList<>();

    public Node(int num) {
        this.num = num;
    }
    
}
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void bfs(int root, Node[] student){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            Integer now = q.poll();
            
            for (Integer next : student[now].taller) {
                q.add(next);
                if(!student[next].shorter.contains(root)) student[next].shorter.add(root);
                if(!student[root].taller.contains(student[next].num)) student[root].taller.add(student[next].num);
            }
        }
        
    }
    
    public static void printStatus(int std, Node[] student){
        for (int i = 1; i < std + 1; i++) {
            System.out.println("학생 : " + i);
            System.out.print("Taller : ");
            for (Integer node : student[i].taller) {
                System.out.print(node + " ");
            }
            System.out.println("");
            System.out.print("Shoter : ");
            for (Integer node : student[i].shorter) {
                System.out.print(node + " ");
            }
            
            System.out.println("");
            System.out.println("");
        }
    }
    
    public static int getStudent(int std, Node[] student){
        int result = 0;
        for (int i = 1; i < std + 1; i++) {
            bfs(i, student);
        }
        
        //printStatus(std, student);
        for (int i = 1; i < std + 1; i++) {
            if(student[i].shorter.size() + student[i].taller.size() == (std - 1)) result++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int std = sc.nextInt();     // 2<= std <= 500
        int comp = sc.nextInt();    // 0 <= comp <= (500 * 499) / 2
        //최대 학생 수 500
        //최대 비교 횟수 124,750
        
        Node[] student = new Node[std + 1];     
        
        for (int i = 0; i < std + 1; i++) {
            student[i] = new Node(i);
        }
        
        for (int i = 0; i < comp; i++) {
            int a = sc.nextInt();
            int b= sc.nextInt();
            student[a].taller.add(b);
        }
        
//        for (int i = 1; i < std + 1; i++) {
//            System.out.print(i + " : ");
//            for (Node node1 : student[i].taller) {
//                System.out.print(node1.num + " ");
//            }
//            System.out.println("");
//        }
        
        System.out.println(getStudent(std, student));
    }
    
}
