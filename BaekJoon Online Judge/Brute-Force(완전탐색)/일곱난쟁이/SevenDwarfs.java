/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 일곱 난쟁이 https://www.acmicpc.net/problem/2309
 *
 * @author DongHyeon Kim <20183188>
 */
public class SevenDwarfs {

    public static void printDwarfs(int[] dwarfs, ArrayList<Integer> picked) {
  
        for (int i = 0; i < 9; i++) {
            if(dwarfs[i] != picked.get(0) && dwarfs[i] != picked.get(1)){
                System.out.println(dwarfs[i]);
            }
        }
        
    }

    public static int getDwarfsSum(int[] dwarfs) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += dwarfs[i];
        }

        return sum;
    }

    public static boolean dwarfsPick(int[] dwarfs, boolean[] visit, ArrayList<Integer> picked, int sum) {
        int thisSum = 0;

        if (picked.size() == 2) {
            thisSum = sum - picked.get(0) - picked.get(1);
        }

        if (thisSum == 100) {
            return true;
        } 
        else {
            int smallest = 0;
            if (!picked.isEmpty()) {
                smallest = picked.get(picked.size() - 1);
            }

            for (int i = 0; i < 9; i++) {
                if (visit[i] == false && (dwarfs[i] > smallest)) {
                    picked.add(dwarfs[i]);
                    visit[i] = true;

                    if(dwarfsPick(dwarfs, visit, picked, sum)) return true;

                    picked.remove(picked.size() - 1);
                    visit[i] = false;
                }
            }
            
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> picked = new ArrayList<>();
        boolean[] visit = new boolean[9];
        int[] dwarfs = new int[9];

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
        }
        Arrays.sort(dwarfs);

        if(dwarfsPick(dwarfs, visit, picked, getDwarfsSum(dwarfs))){
            printDwarfs(dwarfs, picked);
        }

    }

}
