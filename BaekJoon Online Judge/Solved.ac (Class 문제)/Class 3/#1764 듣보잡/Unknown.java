/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologySort.BOJ14676;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        Set<String> name1 = new HashSet<>();
        Set<String> name2 = new HashSet<>();
        
        for (int i = 0; i < N; i++) name1.add(sc.next());
        for (int i = 0; i < M; i++) name2.add(sc.next());
        
        ArrayList<String> list = new ArrayList<>();
        
        Iterator<String> names = name2.iterator();
        
        while(names.hasNext()){
            String next = names.next();
            if(name1.contains(next)) list.add(next);
        }
        
        Collections.sort(list);
        System.out.println(list.size());
        list.forEach(s -> { System.out.println(s);});
    }
    
}
