/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ1253;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class E{
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();
    
    public void add(int n1, int n2){
        this.set1.add(n1);
        this.set2.add(n2);
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int solution(int n, int[] num){
        Hashtable<Integer, E> table = new Hashtable<>();
        int cnt = 0;
        E e;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = num[i] + num[j];
                
                e = table.getOrDefault(sum, new E());
                e.add(i, j);
                
                table.put(sum, e);
            }
        }
        
        for (int i = 0; i < n; i++){
            e = table.getOrDefault(num[i], null);
            if(e == null) continue;
            if(e.set1.contains(i) && e.set1.size() == 1 || e.set2.contains(i) && e.set2.size() == 1) continue;
            cnt++;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        
        for (int i = 0; i < n; i++) num[i] = sc.nextInt();
        
        System.out.println(solution(n, num));
    }
    
}
