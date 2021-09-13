/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ1269;

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
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int sizeA = sc.nextInt(), sizeB = sc.nextInt();
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        
        for (int i = 0; i < sizeA; i++) setA.add(sc.nextInt());
        for (int i = 0; i < sizeB; i++) setB.add(sc.nextInt());
        
        HashSet<Integer> smallSet = setA.size() <= setB.size() ? setA : setB;
        HashSet<Integer> bigSet = setB.size() >= setA.size() ? setB : setA;
        HashSet<Integer> setU = new HashSet<>();
        
        setU.addAll(setA);
        setU.addAll(setB);
        
        Iterator<Integer> set = smallSet.iterator();
        
        while(set.hasNext()){
            int next = set.next();
            if(bigSet.contains(next)) setU.remove(next);
        }
        
        System.out.println(setU.size());
    }
    
}
