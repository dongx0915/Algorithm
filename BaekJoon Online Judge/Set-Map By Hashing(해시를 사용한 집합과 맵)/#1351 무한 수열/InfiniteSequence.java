/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ1351;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static HashMap<Long, Long> sequence;
    
    public static long getSequence(long index, long P, long Q){
        if(sequence.containsKey(index)) return sequence.get(index);
        
        long pi = getSequence(index / P, P, Q);
        long qi = getSequence(index / Q, P, Q);
        sequence.put(index, pi + qi);
        
        return sequence.get(index);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //A[0] = 1
        //A[i] = A[i/P] + a[i/Q] (i >= 1)
        
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long P = sc.nextInt();
        long Q = sc.nextInt();
        
        sequence = new HashMap<>();
        sequence.put((long)0, (long)1);
        
        System.out.println(getSequence(N, P, Q));
    }

}
