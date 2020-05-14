/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 한 수 https://www.acmicpc.net/problem/1065
 * @author DongHyeon Kim <20183188>
 */
public class HanSoo {
 
    public static boolean isHanSoo(int num){
        if((num / 10) < 10) return true; // 2 자리수 이하이면 무조건 한 수
        ArrayList<Integer> save = new ArrayList<>();
        
        while(num != 0){
            save.add(num % 10);
            num /= 10;
        }
        
        int size = save.size();
        for (int i = 0; i < size - 2; i++) {
            if((save.get(i) - save.get(i + 1)) != (save.get(i + 1) - save.get(i + 2))) return false;
        }
        
        return true;
    }
    
    public static int HanSooCnt(int n){
        int Cnt = 0;
        for(int i = 1; i <= n; i++){
            if(isHanSoo(i)) Cnt++;
        }
        
        return Cnt;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.println(HanSooCnt(n));
    }
    
}
