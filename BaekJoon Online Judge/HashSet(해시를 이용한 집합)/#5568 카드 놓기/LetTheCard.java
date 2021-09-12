/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable.BOJ5568;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static HashSet<Integer> set = new HashSet<>();
    public static boolean[] visited;
    
    public static void pickNumber(int[] card, int num, int k){
        if(k == 0){
            set.add(num);
            return;
        }
        
        for (int i = 0; i < card.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                pickNumber(card, num * (int)(Math.pow(10, (int)Math.log10(card[i])+1)) + card[i], k-1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       //총 카드 개수
        int K = sc.nextInt();       //선택할 카드 개수
        int[] card = new int[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) card[i] = sc.nextInt();
        
        pickNumber(card, 0, K);
        System.out.println(set.size());
    }
    
}
