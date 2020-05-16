/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 퇴사 https://www.acmicpc.net/problem/14501
 *
 * @author DongHyeon Kim <20183188>
 */

//        0        1        2        3        4        5        6
//	1일	2일	3일	4일	5일	6일	7일
// Time	3	5	1	1	2	4	2    (기준 : 일)
// Pay	10	20	10	20	15	40	200

public class Resignation {
    static int[] time;
    static int[] pay;
    static boolean[] visit;
    static int max = -1;

    public static int getSum(ArrayList<Integer> picked) {
        int sum = 0;
        for (Integer integer : picked) {
            sum += integer;
        }

        if (max < sum) {
            return sum;
        } else {
            return max;
        }
    }
    
    //selectedIndex = 현재 선택된 항목의 인덱스
    
    public static void SelectCounseling(int n, ArrayList<Integer> picked, ArrayList<Integer> selectIndex, int start) {
        for (int i = start; i < n; i++) {
            picked.add(pay[i]);
            
            if (!visit[i] && (i + time[i]) <= n) {                
                int selectedIndex = i;
                if(!selectIndex.isEmpty()) selectedIndex = selectIndex.get(selectIndex.size()-1);
                selectIndex.add(i);
                
                if (((i - selectedIndex) >= time[selectedIndex]) || (i - selectedIndex) == 0) { // 
                    visit[i] = true;

                    SelectCounseling(n, picked, selectIndex, i + 1);

                    visit[i] = false;                   
                    picked.remove(picked.size() - 1);                    
                    selectIndex.remove(selectIndex.size() - 1);               
                }
                else {
                    
                    if(!picked.isEmpty()) picked.remove(picked.size() - 1);
                    if(!selectIndex.isEmpty()) selectIndex.remove(selectIndex.size() - 1);
                }
            }
            else { //  현재 항목이 선택할 수 없는 항복인 경우
                    if(!picked.isEmpty()) picked.remove(picked.size() - 1);
                }
        }

        max = getSum(picked);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> picked = new ArrayList<>();
        ArrayList<Integer> selectIndex = new ArrayList<>();
        int n = sc.nextInt();

        time = new int[n];
        pay = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        SelectCounseling(n, picked, selectIndex, 0);
        System.out.println(max);
    }
}
