/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ1253;

import java.util.Hashtable;
import java.util.Scanner;

class Pair{
    boolean flag_;
    int index_;

    public Pair(boolean flag_, int index_) {
        this.flag_ = flag_;
        this.index_ = index_;
    }
}


public class Main {
    public static int solution(int n, int[] num, Hashtable<Integer, Pair> table){
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = num[i] + num[j];

                Pair p = table.getOrDefault(sum, null);
                
                if (p == null || p.index_ == i || p.index_ == j) continue;
                
                p.flag_ = true;
                table.put(sum, p);
            }
        }
        
        for (int i = 0; i < n; i++) if(table.get(num[i]).flag_) cnt++;
        
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        Hashtable<Integer, Pair> table = new Hashtable<>();
        
        for (int i = 0; i < n; i++) {
            table.put((num[i] = sc.nextInt()), new Pair(false, i));
        }
        
        System.out.println(solution(n, num, table));
    }
}
