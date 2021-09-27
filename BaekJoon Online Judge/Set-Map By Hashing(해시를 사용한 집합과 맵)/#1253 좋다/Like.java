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
    int n1_;
    int n2_;

    public E(int n1_, int n2_) {
        this.n1_ = n1_;
        this.n2_ = n2_;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof E) return (this.n1_ == ((E) o).n1_) && (this.n2_ == ((E) o).n2_);
        return false;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int solution(int n, int[] num){
        Hashtable<Integer, HashSet<E>> table = new Hashtable<>();
        int cnt = 0;
        HashSet<E> set;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = num[i] + num[j];
                
                set = table.getOrDefault(sum, new HashSet<>());
                set.add(new E(num[i], num[j]));
                
                table.put(sum, set);
            }
        }
        
        for (int i : num){
            set = table.get(i);
            
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
