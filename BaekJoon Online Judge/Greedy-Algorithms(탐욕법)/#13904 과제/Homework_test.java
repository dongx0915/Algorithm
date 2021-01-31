/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Homework implements Comparable<Homework>{
    int deadline;
    int score;

    public Homework(int deadline, int score) {
        this.deadline = deadline;
        this.score = score;
    }
    
    @Override
    public int compareTo(Homework o){
        return o.score- this.score;
    }
}
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int[] homework_day;
    public static int[] copy_homework_day;
    public static int getMaxScore(int max_dead, Homework[] hw){
        int sum = 0;
        
        for (Homework h : hw) {
            for (int i = h.deadline; i > 0; i--) {
                if(homework_day[i] == 0){
                    homework_day[i] = h.score;
                    break;
                }
            }
        }
        
        for (int i : homework_day) sum += i;
        return sum;
    }
    
    public static int getMaxScore_wrong(int max_dead, Homework[] hw) {
        int sum = 0;
        
        for (Homework h : hw) {
            if(copy_homework_day[h.deadline] == 0) copy_homework_day[h.deadline] = h.score;
            else{
                for (int i = h.deadline; i > 0; i--) {
                    if(copy_homework_day[i] < h.score){
                        copy_homework_day[i] = h.score;
                        break;
                    }
                }
            }
        }
        
        for (int i : copy_homework_day) sum += i;
        return sum;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        while(true){
            System.out.println("테스트 " + cnt++ + " 통과");
            int n = (int) (Math.random() * 5) + 1; //sc.nextInt();
            int max_dead = -1;
            Homework[] hw = new Homework[n];
            Homework[] copy_hw = new Homework[n];

            for (int i = 0; i < n; i++) {
                int d = (int) (Math.random() * 9) + 1;//sc.nextInt();
                int s = (int) (Math.random() * 99) + 1; // sc.nextInt();

                hw[i] = new Homework(d, s);
                copy_hw[i] = new Homework(d, s);
                max_dead = Math.max(max_dead, hw[i].deadline);
            }

            homework_day = new int[max_dead + 1];
            copy_homework_day = new int[max_dead + 1];
            Arrays.sort(hw);
            Arrays.sort(copy_hw);

            int answer = getMaxScore(max_dead, hw);
            int my =getMaxScore_wrong(max_dead, copy_hw); 
            if (answer != my) {
                System.out.println("n = " + n);
                for (Homework homework : hw) {
                    System.out.println(homework.deadline + " " + homework.score);
                }
                System.out.println("");
                System.out.println("answer = " + answer);
                System.out.println("my = " + my);
                break;
            }
        }
//        System.out.println(getMaxScore(max_dead, hw));
//        System.out.println(getMaxScore_wrong(max_dead, copy_hw));
    }
    
}
