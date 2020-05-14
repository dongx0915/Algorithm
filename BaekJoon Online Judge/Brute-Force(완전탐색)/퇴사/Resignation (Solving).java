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


//      10
//	0	1 	2	3	4	5	6	7	8	9	
//
//time[i]      5	4	3	2	1	1	2	3	4	5
//pay[i]     50	40	30	20	10	10	20	30	40	50
//
//	0	1	2	3	4	5
//	1	2	2	1	1	1
//
//첫번 째 if {
//	visit[i] == false, 	i + time[i] 가 n보다 작거나 같을 때 (인덱스 + 시간이 N을 넘지않을 떄)
//	두번 째 if {
//		i - nowIndex 가 time[nowIndex] 보다 크거나 같을 때 ( 골라야 할 인덱스가 이전에 고른 시간보다 작은 경우) or (i - nowIndex ) 가 0인경우 (첫번째 원소)
//
//
//
//50 10 20 
//50 10 
//50 20 
//50 
//10 20 
//10 
//20 

public class Resignation {

    static int[] time;
    static int[] pay;
    static boolean[] visit;
    static int max = -1;

    public static void PrintPick(ArrayList<Integer> picked) {
        picked.forEach((s) -> {
            System.out.print(s + " ");
        });
        System.out.println("");
    }

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

    public static void SelectCounseling(int n, ArrayList<Integer> picked, int nowIndex, int start) {
//        if(nowIndex + time[nowIndex] > n){
//            PrintPick(picked);
//            return;
//        }

        for (int i = start; i < n; i++) {
            if (!visit[i] && (i + time[i]) <= n) {
                if (((i - nowIndex) >= time[nowIndex]) || (i - nowIndex) == 0) {
                    visit[i] = true;
                    picked.add(pay[i]);
                    nowIndex = i;

                    SelectCounseling(n, picked, nowIndex, i + 1);

                    nowIndex = i;
                    visit[i] = false;
                    picked.remove(picked.size() - 1);
                }
            }
        }

        PrintPick(picked);
        max = getSum(picked);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> picked = new ArrayList<>();
        int n = sc.nextInt();

        time = new int[n];
        pay = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        SelectCounseling(n, picked, 0, 0);
        System.out.println(max);
    }
}


/*

    public static int SelectCounseling(int n) {
        int max = -1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if((i + time[i]) < n)sum += pay[i];
            System.out.printf("i = %d\n", i);
            int index = i + time[i];

            while (index < n) {
                System.out.printf("index = %d\n", index);
                if(index + time[index] <= n) sum += pay[index];
                
                index += time[index];
               
            }

            if (max < sum) {
                max = sum;
            }

            System.out.println("sum = " + sum + "\n");
        }
        return max;
    }
 */
