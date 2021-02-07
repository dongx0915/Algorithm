/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon1202;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Jewelry implements Comparable<Jewelry>{
    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    
    @Override
    public int compareTo(Jewelry o){
        if(this.value != o.value) return o.value - this.value;
        else return this.weight - o.weight;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static long getMaxPrice(int n, int k, PriorityQueue<Integer> bag, PriorityQueue<Jewelry> jw){
        long result = 0;
        Object[] bags = (Object[])bag.toArray();
        
        while(!jw.isEmpty()){
            Jewelry now = jw.poll();
            
            for (Object b : bags) {
                if((Integer)b == -1) continue;
                if(now.weight <= (Integer)b){
                    System.out.println(now.value);
                    b = -1;
                    result += now.value;
                }
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 보석의 개수
        int k = sc.nextInt();       // 가방의 개수
        
        PriorityQueue<Jewelry> jw_pq = new PriorityQueue<>();
        PriorityQueue<Integer> bag_pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            jw_pq.add(new Jewelry(sc.nextInt(), sc.nextInt()));
        }
        
        for (int i = 0; i < k; i++) {
            bag_pq.add(sc.nextInt());
        }
        
        bag_pq.forEach(integer -> {
            System.out.println(integer);
        });
        
        System.out.println(getMaxPrice(n,k,bag_pq,jw_pq));
    }
    
}
