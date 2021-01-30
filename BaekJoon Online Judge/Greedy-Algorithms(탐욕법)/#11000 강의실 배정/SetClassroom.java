/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetClassRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Lecture implements Comparable<Lecture>{
    int start_time;
    int end_time;

    public Lecture(int start_time, int end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    @Override
    public int compareTo(Lecture o) {
        if(this.end_time == o.end_time) return this.start_time - o.start_time;
        return this.end_time - o.end_time;
    }
}

public class Main {
    public static int getClassroom(ArrayList<Lecture> lec_list){
        if(lec_list.isEmpty()) return 0;
        Lecture now_lec = lec_list.get(0);
        lec_list.remove(now_lec);
        
        for (int i = 0; i < lec_list.size(); i++) {
            Lecture next_lec = lec_list.get(i);
            if(now_lec.end_time <= next_lec.start_time){
                lec_list.remove(next_lec);
                now_lec = next_lec;
            }
        }
        return 1 + getClassroom(lec_list);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Lecture> lec_list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            lec_list.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }
        
        Collections.sort(lec_list);
//        lec_list.forEach(classroom -> {
//            System.out.println(classroom.start_time + " " + classroom.end_time);
//        });
        
        System.out.println(getClassroom(lec_list));
        
    }
    
}
