/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon1202;

import java.util.Arrays;
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
    boolean selected = false;
    
    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    @Override
    public int compareTo(Jewelry o){
        return this.weight - o.weight;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static long getMaxPrice(int n, int k, int[] bag, Jewelry[] jw){
        long result = 0;
        int jw_cnt = 0;
        PriorityQueue<Integer> bag_value = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            while(jw_cnt < n && jw[jw_cnt].weight <= bag[i]){
                bag_value.add(jw[jw_cnt].value * -1);
                jw_cnt++;
            }
            
            if(!bag_value.isEmpty()){
                result += Math.abs(bag_value.poll());
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 보석의 개수
        int k = sc.nextInt();       // 가방의 개수
        Jewelry[] jw = new Jewelry[n];
        int[] bag = new int[k];
        
        for (int i = 0; i < n; i++) {
            jw[i] = new Jewelry(sc.nextInt(), sc.nextInt());
        }
        
        for (int i = 0; i < k; i++) {
            bag[i] = sc.nextInt();
        }
        
        Arrays.sort(jw);                          // 정렬을 한다고해서 무조건 (N^2, NlogN이 되는 건 아니다)
        Arrays.sort(bag);                         // n과 k가 각각 300,000까지 들어온다. 정렬을 하면 시간 복잡도는 nlogn + klogk이다. (Arrays.sort()의 시간 복잡도는 nlogn)
                                                  // 가방 용량 순으로, 보석은 가격 순으로 정렬하여 2중 포문을 돌리면 300,000 * 300,000 으로 900억만큼 돌아야하므로 정렬보다 
                                                  // 이 부분의 시간을 줄이는데에 중점을 
        System.out.println(getMaxPrice(n,k,bag,jw));
    }
    
}
