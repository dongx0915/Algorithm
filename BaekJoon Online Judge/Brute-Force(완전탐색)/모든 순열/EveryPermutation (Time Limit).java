/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 모든 순열 https://www.acmicpc.net/problem/10974
 * @author DongHyeon Kim <20183188>
 */
class myList{
    int num;
    boolean isSelected = false;
    
    public myList(int num) {
        this.num = num;
    }
}


public class Main {
    public static void printPicked(ArrayList<Integer> picked){
        int size = picked.size();
        
        for (int i = 0; i < size; i++) {
            if(i == (size - 1)) System.out.println(picked.get(i) + 1);
            else System.out.printf("%d ", picked.get(i) + 1);
        }
    }
    
    public static void permutation(int n, ArrayList<Integer> picked, myList[] init, int PickCnt){
        if(PickCnt == 0) {
            printPicked(picked);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(init[i].isSelected == false){
                picked.add(i);
                init[i].isSelected = true;
                
                permutation(n, picked, init, PickCnt - 1);
                
                picked.remove(picked.size() - 1);
                init[i].isSelected = false;
            }
        }

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        myList[] init = new myList[n];
        
        for (int i = 0; i < n; i++) {
            init[i] = new myList(i + 1);
        }
        ArrayList<Integer> picked = new ArrayList<>();
        
        permutation(n, picked, init, n);
    }
    
}
